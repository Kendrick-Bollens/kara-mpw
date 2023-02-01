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
* Initialize a hamster object with the given parameters. Once a hamster is initialized, the method must not be called again.<br/>
* <br/>
* <b>requires / ensures:</b> the hamster is placed on a tile.<br/>
* <b>requires:</b> the hamster must not be already initialized<br/>
* <b>requires:</b> location has to be on territory
* 
*/

public class InitHamsterCommand extends CompositeCommandBase {
	private final ConcreteHamster self;
	private final GameLog gameLog;

	private final GameTerritory territory;

	private final Location location;

	private final Direction direction;

	public InitHamsterCommand(InitHamsterCommandParameters parameters) {
		this.self = parameters.self;
		this.gameLog = parameters.gameLog;
		this.territory = parameters.territory;
		this.location = parameters.location;
		this.direction = parameters.direction;
	}

	@Override
	public void execute() {

		/*
		* the hamster must not be already initialized
		*/

		if ((self.getStage() == null) == false) {
			throw new CommandConstraintException(
					"Violation of Precondition: the hamster must not be already initialized");
		}

		/*
		* location has to be on territory
		*/

		if ((territory.isLocationInTerritory(location)) == false) {
			throw new CommandConstraintException("Violation of Precondition: location has to be on territory");
		}

		if (!internalMainUnit()) {
			throw new RuntimeException("Transformation was not successfully executed: initHamster");
		}
		addGameLog();

		/*
		* the hamster is placed on a tile.
		*/

		if ((self.getStage() != null && self.getCurrentTile() != null) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the hamster is placed on a tile.");
		}

	}
	private boolean internalMainUnit() {

		boolean result;

		result = addToTerritory(territory, location);

		if (!result) {
			return false;
		}

		result = setProperties(direction);

		if (!result) {
			return false;
		}

		return true;

	}

	private boolean setProperties(Direction initialDirection) {

		// set value type field self.direction := initialDirection
		executeSetProperty(self, "direction", self.getDirection(), initialDirection);

		return true;

	}

	private boolean addToTerritory(GameTerritory territory, Location location) {

		// find new variable from many-reference: territory:GameTerritory -> tiles -> o0:Tile

		Tile o0 = addToTerritory_findO0(territory);
		if (o0 == null) {
			return false;
		}

		// new variable from reference: o0:Tile -> location -> o1:Location

		Location o1 = o0.getLocation();
		if (o1 == null) {
			return false;
		}

		// assert condition: o1.row == location.row
		if (o1.getRow() != location.getRow()) {
			return false;
		}

		// assert condition: o1.column == location.column
		if (o1.getColumn() != location.getColumn()) {
			return false;
		}

		// create reference: CREATE territory:GameTerritory -> tileContents -> self:GameHamster
		executeAddReference(territory, "tileContents", self);

		// create reference: CREATE self:GameHamster -> currentTile -> o0:Tile
		executeSetProperty(self, "currentTile", self.getCurrentTile(), o0);

		return true;

	}

	private Tile addToTerritory_findO0(GameTerritory source) {
		Tile result = null;

		for (Tile o0 : source.getTiles()) {

			// reference check: o0: location

			Location o1 = o0.getLocation();
			if (o1 == null) {

				continue;
			}

			// attribute check: o1: row
			if (o1.getRow() != location.getRow()) {
				continue;
			}

			// attribute check: o1: column
			if (o1.getColumn() != location.getColumn()) {
				continue;
			}

			result = o0;
			break;
		}
		return result;
	}

	private boolean addGameLog() {

		// new instance: entry:LogEntry
		LogEntry entry = new LogEntry();

		// set value type field entry.message := 
		executeSetProperty(entry, "message", entry.getMessage(), "Init Hamster");

		// create reference: CREATE entry:LogEntry -> actor -> self:GameHamster
		executeSetProperty(entry, "actor", entry.getActor(), self);

		// create reference: CREATE gameLog:GameLog -> logEntries -> entry:LogEntry
		executeAddReference(gameLog, "logEntries", entry);

		return true;

	}

}
