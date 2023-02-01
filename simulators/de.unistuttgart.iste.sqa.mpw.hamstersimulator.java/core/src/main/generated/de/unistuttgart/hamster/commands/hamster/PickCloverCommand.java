/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.commands.hamster;

import static de.unistuttgart.iste.sqa.mpw.framework.FrameworkAssert.*;
import de.unistuttgart.iste.sqa.mpw.framework.exceptions.*;
import de.unistuttgart.hamster.hamster.*;

import de.unistuttgart.iste.sqa.mpw.framework.mpw.*;
import de.unistuttgart.iste.sqa.mpw.framework.commands.*;
import de.unistuttgart.iste.sqa.mpw.framework.commands.impl.*;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.*;
import static de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction.*;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction.*;
import de.unistuttgart.iste.sqa.mpw.framework.utils.*;
import java.util.stream.Collectors;

/**
* <br/>
* <br/>
* <b>requires / ensures:</b> the hamster is placed on a tile.<br/>
* <b>ensures:</b> on the current tile, now only the hamster has to be contained<br/>
* <b>requires:</b> on the current tile, a breadcrumb has to be contained
* 
*/

public class PickCloverCommand extends CompositeCommandBase {
	private final ConcreteHamster self;
	private final GameLog gameLog;

	public PickCloverCommand(PickCloverCommandParameters parameters) {
		this.self = parameters.self;
		this.gameLog = parameters.gameLog;
	}

	@Override
	public void execute() {

		/*
		* on the current tile, a breadcrumb has to be contained
		*/

		if ((self.cloverAvailable()) == false) {
			throw new CommandConstraintException(
					"Violation of Precondition: on the current tile, a breadcrumb has to be contained");
		}

		/*
		* the hamster is placed on a tile.
		*/

		if ((self.getStage() != null && self.getCurrentTile() != null) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the hamster is placed on a tile.");
		}

		if (!internalMainUnit()) {
			throw new RuntimeException("Transformation was not successfully executed: pickClover");
		}
		addGameLog();

		/*
		* on the current tile, now only the hamster has to be contained
		*/

		if ((helperPostcondition2CurrentTileResult0ContentsSize() == 1
				&& helperPostcondition2CurrentTileResult0ContentsAt0() == self) == false) {
			throw new CommandConstraintException(
					"Violation of Postcondition: on the current tile, now only the hamster has to be contained");
		}

		/*
		* the hamster is placed on a tile.
		*/

		if ((self.getStage() != null && self.getCurrentTile() != null) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the hamster is placed on a tile.");
		}

	}
	private boolean internalMainUnit() {

		// new variable from reference: self:GameHamster -> currentTile -> o0:Tile

		Tile o0 = self.getCurrentTile();
		if (o0 == null) {
			return false;
		}

		// new variable from reference: self:GameHamster -> stage -> o2:GameTerritory

		GameTerritory o2 = (self.getStage() instanceof GameTerritory) ? (GameTerritory) self.getStage() : null;
		if (o2 == null) {
			return false;
		}

		// find new variable from many-reference: o0:Tile -> contents -> o1:Clover

		Clover o1 = execute_findO1(o0);
		if (o1 == null) {
			return false;
		}

		if (!o2.getTileContents().contains(self)) {
			return false;
		}

		if (o2 != o1.getStage()) {
			return false;
		}

		// remove reference: DELETE o0:Tile -> contents -> o1:Clover

		executeRemoveReference(o0, "contents", o1);

		// remove reference: DELETE o1:Clover -> stage -> o2:GameTerritory

		executeSetProperty(o1, "stage", o1.getStage(), null);

		return true;

	}

	private Clover execute_findO1(Tile source) {
		Clover result = null;

		for (TileContent o1TileContent : source.getContents()) {

			if (!(o1TileContent instanceof Clover)) {
				continue;
			}
			Clover o1 = (Clover) o1TileContent;

			// reference check: o1: stage

			GameTerritory o2 = (o1.getStage() instanceof GameTerritory) ? (GameTerritory) o1.getStage() : null;
			if (o2 == null) {

				continue;
			}

			result = o1;
			break;
		}
		return result;
	}

	private boolean addGameLog() {

		// new instance: entry:LogEntry
		LogEntry entry = new LogEntry();

		// set value type field entry.message := 
		executeSetProperty(entry, "message", entry.getMessage(), "Pick Clover");

		// create reference: CREATE entry:LogEntry -> actor -> self:GameHamster
		executeSetProperty(entry, "actor", entry.getActor(), self);

		// create reference: CREATE gameLog:GameLog -> logEntries -> entry:LogEntry
		executeAddReference(gameLog, "logEntries", entry);

		return true;

	}

	private int helperPostcondition2CurrentTileResult0ContentsSize() {
		Tile result0 = self.getCurrentTile();
		if (result0 == null) {
			return 0;
		}
		int result1 = result0.getContents().size();
		return result1;
	}

	private TileContent helperPostcondition2CurrentTileResult0ContentsAt0() {
		Tile result0 = self.getCurrentTile();
		if (result0 == null) {
			return null;
		}
		TileContent result1 = result0.getContents().get(0);
		return result1;
	}

}
