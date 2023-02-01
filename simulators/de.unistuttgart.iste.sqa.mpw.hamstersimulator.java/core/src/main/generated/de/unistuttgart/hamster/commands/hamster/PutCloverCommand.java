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
* <b>requires:</b> on the current tile, only the hamster has to be contained<br/>
* <b>ensures:</b> on the current tile, now also a breadcrumb has to be contained
* 
*/

public class PutCloverCommand extends CompositeCommandBase {
	private final ConcreteHamster self;
	private final GameLog gameLog;

	public PutCloverCommand(PutCloverCommandParameters parameters) {
		this.self = parameters.self;
		this.gameLog = parameters.gameLog;
	}

	@Override
	public void execute() {

		/*
		* on the current tile, only the hamster has to be contained
		*/

		if ((helperPrecondition2CurrentTileResult0ContentsSize() == 1
				&& helperPrecondition2CurrentTileResult0ContentsAt0() == self) == false) {
			throw new CommandConstraintException(
					"Violation of Precondition: on the current tile, only the hamster has to be contained");
		}

		/*
		* the hamster is placed on a tile.
		*/

		if ((self.getStage() != null && self.getCurrentTile() != null) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the hamster is placed on a tile.");
		}

		if (!internalMainUnit()) {
			throw new RuntimeException("Transformation was not successfully executed: putClover");
		}
		addGameLog();

		/*
		* on the current tile, now also a breadcrumb has to be contained
		*/

		if ((helperPostcondition1CurrentTileResult0ContentsSize() == 2 && self.cloverAvailable()) == false) {
			throw new CommandConstraintException(
					"Violation of Postcondition: on the current tile, now also a breadcrumb has to be contained");
		}

		/*
		* the hamster is placed on a tile.
		*/

		if ((self.getStage() != null && self.getCurrentTile() != null) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the hamster is placed on a tile.");
		}

	}
	private boolean internalMainUnit() {

		// new instance: o2:Clover
		Clover o2 = new Clover();

		// new variable from reference: self:GameHamster -> stage -> o0:GameTerritory

		GameTerritory o0 = (self.getStage() instanceof GameTerritory) ? (GameTerritory) self.getStage() : null;
		if (o0 == null) {
			return false;
		}

		// new variable from reference: self:GameHamster -> currentTile -> o1:Tile

		Tile o1 = self.getCurrentTile();
		if (o1 == null) {
			return false;
		}

		if (!o0.getTileContents().contains(self)) {
			return false;
		}

		// create reference: CREATE o1:Tile -> contents -> o2:Clover
		executeAddReference(o1, "contents", o2);

		// create reference: CREATE o2:Clover -> stage -> o0:GameTerritory
		executeSetProperty(o2, "stage", o2.getStage(), o0);

		return true;

	}

	private boolean addGameLog() {

		// new instance: entry:LogEntry
		LogEntry entry = new LogEntry();

		// set value type field entry.message := 
		executeSetProperty(entry, "message", entry.getMessage(), "Put Clover");

		// create reference: CREATE entry:LogEntry -> actor -> self:GameHamster
		executeSetProperty(entry, "actor", entry.getActor(), self);

		// create reference: CREATE gameLog:GameLog -> logEntries -> entry:LogEntry
		executeAddReference(gameLog, "logEntries", entry);

		return true;

	}

	private TileContent helperPrecondition2CurrentTileResult0ContentsAt0() {
		Tile result0 = self.getCurrentTile();
		if (result0 == null) {
			return null;
		}
		TileContent result1 = result0.getContents().get(0);
		return result1;
	}

	private int helperPrecondition2CurrentTileResult0ContentsSize() {
		Tile result0 = self.getCurrentTile();
		if (result0 == null) {
			return 0;
		}
		int result1 = result0.getContents().size();
		return result1;
	}

	private int helperPostcondition1CurrentTileResult0ContentsSize() {
		Tile result0 = self.getCurrentTile();
		if (result0 == null) {
			return 0;
		}
		int result1 = result0.getContents().size();
		return result1;
	}

}
