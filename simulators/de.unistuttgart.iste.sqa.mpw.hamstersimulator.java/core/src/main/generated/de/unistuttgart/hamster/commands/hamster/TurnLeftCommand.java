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
* Changes the looking direction 90 degrees to the left, e.g., when looking north the hamster will look towards west afterwards.<br/>
* <br/>
* <b>requires / ensures:</b> the hamster is placed on a tile.
* 
*/

public class TurnLeftCommand extends CompositeCommandBase {
	private final ConcreteHamster self;
	private final GameLog gameLog;

	public TurnLeftCommand(TurnLeftCommandParameters parameters) {
		this.self = parameters.self;
		this.gameLog = parameters.gameLog;
	}

	@Override
	public void execute() {

		/*
		* the hamster is placed on a tile.
		*/

		if ((self.getStage() != null && self.getCurrentTile() != null) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the hamster is placed on a tile.");
		}

		if (!internalMainUnit()) {
			throw new RuntimeException("Transformation was not successfully executed: turnLeft");
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

		result = turnLeftNorth();

		if (result) {

			return true;
		}

		result = turnLeftSouth();

		if (result) {

			return true;
		}

		result = turnLeftWest();

		if (result) {

			return true;
		}

		result = turnLeftEast();

		if (result) {

			return true;
		}

		return false;

	}

	private boolean turnLeftNorth() {

		// assert condition: self.direction == NORTH
		if (self.getDirection() != NORTH) {
			return false;
		}

		// set attribute: self.direction := WEST
		executeSetProperty(self, "direction", self.getDirection(), WEST);

		return true;

	}

	private boolean turnLeftSouth() {

		// assert condition: self.direction == SOUTH
		if (self.getDirection() != SOUTH) {
			return false;
		}

		// set attribute: self.direction := EAST
		executeSetProperty(self, "direction", self.getDirection(), EAST);

		return true;

	}

	private boolean turnLeftWest() {

		// assert condition: self.direction == WEST
		if (self.getDirection() != WEST) {
			return false;
		}

		// set attribute: self.direction := SOUTH
		executeSetProperty(self, "direction", self.getDirection(), SOUTH);

		return true;

	}

	private boolean turnLeftEast() {

		// assert condition: self.direction == EAST
		if (self.getDirection() != EAST) {
			return false;
		}

		// set attribute: self.direction := NORTH
		executeSetProperty(self, "direction", self.getDirection(), NORTH);

		return true;

	}

	private boolean addGameLog() {

		// new instance: entry:LogEntry
		LogEntry entry = new LogEntry();

		// set value type field entry.message := 
		executeSetProperty(entry, "message", entry.getMessage(), "Turn Left");

		// create reference: CREATE entry:LogEntry -> actor -> self:GameHamster
		executeSetProperty(entry, "actor", entry.getActor(), self);

		// create reference: CREATE gameLog:GameLog -> logEntries -> entry:LogEntry
		executeAddReference(gameLog, "logEntries", entry);

		return true;

	}

}
