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

public class MoveCommand extends CompositeCommandBase {
	private final ConcreteHamster self;
	private final GameLog gameLog;

	public MoveCommand(MoveCommandParameters parameters) {
		this.self = parameters.self;
		this.gameLog = parameters.gameLog;
	}

	@Override
	public void execute() {

		/*
		* Hamster front must not be blocked or outside territory
		*/

		if ((self.frontIsClear()) == false) {
			throw new CommandConstraintException(
					"Violation of Precondition: Hamster front must not be blocked or outside territory");
		}

		if ((self.behindMushroomIsClear()) == false) {
			throw new CommandConstraintException("Violation of Precondition");
		}

		/*
		* the hamster is placed on a tile.
		*/

		if ((self.getStage() != null && self.getCurrentTile() != null) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the hamster is placed on a tile.");
		}

		if (!internalMainUnit()) {
			throw new RuntimeException("Transformation was not successfully executed: move");
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

		result = moveMushroom();

		if (!result) {
			return false;
		}

		result = moveHamster();

		if (!result) {
			return false;
		}

		return true;

	}

	private boolean moveNorth() {

		// new variable from reference: self:GameHamster -> currentTile -> current:Tile

		Tile current = self.getCurrentTile();
		if (current == null) {
			return false;
		}

		// new variable from reference: current:Tile -> north -> front:Tile

		Tile front = current.getNorth();
		if (front == null) {
			return false;
		}

		// assert condition: self.direction == NORTH
		if (self.getDirection() != NORTH) {
			return false;
		}

		// remove reference: DELETE self:GameHamster -> currentTile -> current:Tile

		executeSetProperty(self, "currentTile", self.getCurrentTile(), null);

		// create reference: CREATE self:GameHamster -> currentTile -> front:Tile
		executeSetProperty(self, "currentTile", self.getCurrentTile(), front);

		return true;

	}

	private boolean moveSouth() {

		// new variable from reference: self:GameHamster -> currentTile -> current:Tile

		Tile current = self.getCurrentTile();
		if (current == null) {
			return false;
		}

		// new variable from reference: current:Tile -> south -> front:Tile

		Tile front = current.getSouth();
		if (front == null) {
			return false;
		}

		// assert condition: self.direction == SOUTH
		if (self.getDirection() != SOUTH) {
			return false;
		}

		// remove reference: DELETE self:GameHamster -> currentTile -> current:Tile

		executeSetProperty(self, "currentTile", self.getCurrentTile(), null);

		// create reference: CREATE self:GameHamster -> currentTile -> front:Tile
		executeSetProperty(self, "currentTile", self.getCurrentTile(), front);

		return true;

	}

	private boolean moveWest() {

		// new variable from reference: self:GameHamster -> currentTile -> current:Tile

		Tile current = self.getCurrentTile();
		if (current == null) {
			return false;
		}

		// new variable from reference: current:Tile -> west -> front:Tile

		Tile front = current.getWest();
		if (front == null) {
			return false;
		}

		// assert condition: self.direction == WEST
		if (self.getDirection() != WEST) {
			return false;
		}

		// remove reference: DELETE self:GameHamster -> currentTile -> current:Tile

		executeSetProperty(self, "currentTile", self.getCurrentTile(), null);

		// create reference: CREATE self:GameHamster -> currentTile -> front:Tile
		executeSetProperty(self, "currentTile", self.getCurrentTile(), front);

		return true;

	}

	private boolean moveEast() {

		// new variable from reference: self:GameHamster -> currentTile -> current:Tile

		Tile current = self.getCurrentTile();
		if (current == null) {
			return false;
		}

		// new variable from reference: current:Tile -> east -> front:Tile

		Tile front = current.getEast();
		if (front == null) {
			return false;
		}

		// assert condition: self.direction == EAST
		if (self.getDirection() != EAST) {
			return false;
		}

		// remove reference: DELETE self:GameHamster -> currentTile -> current:Tile

		executeSetProperty(self, "currentTile", self.getCurrentTile(), null);

		// create reference: CREATE self:GameHamster -> currentTile -> front:Tile
		executeSetProperty(self, "currentTile", self.getCurrentTile(), front);

		return true;

	}

	private boolean moveMushroomNorth() {

		// new variable from reference: self:GameHamster -> currentTile -> hamster:Tile

		Tile hamster = self.getCurrentTile();
		if (hamster == null) {
			return false;
		}

		// new variable from reference: hamster:Tile -> north -> currentMushroom:Tile

		Tile currentMushroom = hamster.getNorth();
		if (currentMushroom == null) {
			return false;
		}

		// find new variable from many-reference: currentMushroom:Tile -> contents -> o0:Mushroom

		Mushroom o0 = moveMushroomNorth_findO0(currentMushroom);
		if (o0 == null) {
			return false;
		}

		// new variable from reference: currentMushroom:Tile -> north -> frontMushroom:Tile

		Tile frontMushroom = currentMushroom.getNorth();
		if (frontMushroom == null) {
			return false;
		}

		// assert condition: self.direction == NORTH
		if (self.getDirection() != NORTH) {
			return false;
		}

		// remove reference: DELETE currentMushroom:Tile -> contents -> o0:Mushroom

		executeRemoveReference(currentMushroom, "contents", o0);

		// create reference: CREATE o0:Mushroom -> currentTile -> frontMushroom:Tile
		executeSetProperty(o0, "currentTile", o0.getCurrentTile(), frontMushroom);

		return true;

	}

	private Mushroom moveMushroomNorth_findO0(Tile source) {
		Mushroom result = null;

		for (TileContent o0TileContent : source.getContents()) {

			if (!(o0TileContent instanceof Mushroom)) {
				continue;
			}
			Mushroom o0 = (Mushroom) o0TileContent;

			result = o0;
			break;
		}
		return result;
	}

	private boolean moveMushroomSouth() {

		// new variable from reference: self:GameHamster -> currentTile -> hamster:Tile

		Tile hamster = self.getCurrentTile();
		if (hamster == null) {
			return false;
		}

		// new variable from reference: hamster:Tile -> south -> currentMushroom:Tile

		Tile currentMushroom = hamster.getSouth();
		if (currentMushroom == null) {
			return false;
		}

		// new variable from reference: currentMushroom:Tile -> south -> frontMushroom:Tile

		Tile frontMushroom = currentMushroom.getSouth();
		if (frontMushroom == null) {
			return false;
		}

		// find new variable from many-reference: currentMushroom:Tile -> contents -> o0:Mushroom

		Mushroom o0 = moveMushroomSouth_findO0(currentMushroom);
		if (o0 == null) {
			return false;
		}

		// assert condition: self.direction == SOUTH
		if (self.getDirection() != SOUTH) {
			return false;
		}

		// remove reference: DELETE currentMushroom:Tile -> contents -> o0:Mushroom

		executeRemoveReference(currentMushroom, "contents", o0);

		// create reference: CREATE o0:Mushroom -> currentTile -> frontMushroom:Tile
		executeSetProperty(o0, "currentTile", o0.getCurrentTile(), frontMushroom);

		return true;

	}

	private Mushroom moveMushroomSouth_findO0(Tile source) {
		Mushroom result = null;

		for (TileContent o0TileContent : source.getContents()) {

			if (!(o0TileContent instanceof Mushroom)) {
				continue;
			}
			Mushroom o0 = (Mushroom) o0TileContent;

			result = o0;
			break;
		}
		return result;
	}

	private boolean moveMushroomWest() {

		// new variable from reference: self:GameHamster -> currentTile -> hamster:Tile

		Tile hamster = self.getCurrentTile();
		if (hamster == null) {
			return false;
		}

		// new variable from reference: hamster:Tile -> west -> currentMushroom:Tile

		Tile currentMushroom = hamster.getWest();
		if (currentMushroom == null) {
			return false;
		}

		// new variable from reference: currentMushroom:Tile -> west -> frontMushroom:Tile

		Tile frontMushroom = currentMushroom.getWest();
		if (frontMushroom == null) {
			return false;
		}

		// find new variable from many-reference: currentMushroom:Tile -> contents -> o0:Mushroom

		Mushroom o0 = moveMushroomWest_findO0(currentMushroom);
		if (o0 == null) {
			return false;
		}

		// assert condition: self.direction == WEST
		if (self.getDirection() != WEST) {
			return false;
		}

		// remove reference: DELETE currentMushroom:Tile -> contents -> o0:Mushroom

		executeRemoveReference(currentMushroom, "contents", o0);

		// create reference: CREATE o0:Mushroom -> currentTile -> frontMushroom:Tile
		executeSetProperty(o0, "currentTile", o0.getCurrentTile(), frontMushroom);

		return true;

	}

	private Mushroom moveMushroomWest_findO0(Tile source) {
		Mushroom result = null;

		for (TileContent o0TileContent : source.getContents()) {

			if (!(o0TileContent instanceof Mushroom)) {
				continue;
			}
			Mushroom o0 = (Mushroom) o0TileContent;

			result = o0;
			break;
		}
		return result;
	}

	private boolean moveMushroomEast() {

		// new variable from reference: self:GameHamster -> currentTile -> hamster:Tile

		Tile hamster = self.getCurrentTile();
		if (hamster == null) {
			return false;
		}

		// new variable from reference: hamster:Tile -> east -> currentMushroom:Tile

		Tile currentMushroom = hamster.getEast();
		if (currentMushroom == null) {
			return false;
		}

		// new variable from reference: currentMushroom:Tile -> east -> frontMushroom:Tile

		Tile frontMushroom = currentMushroom.getEast();
		if (frontMushroom == null) {
			return false;
		}

		// find new variable from many-reference: currentMushroom:Tile -> contents -> o0:Mushroom

		Mushroom o0 = moveMushroomEast_findO0(currentMushroom);
		if (o0 == null) {
			return false;
		}

		// assert condition: self.direction == EAST
		if (self.getDirection() != EAST) {
			return false;
		}

		// remove reference: DELETE currentMushroom:Tile -> contents -> o0:Mushroom

		executeRemoveReference(currentMushroom, "contents", o0);

		// create reference: CREATE o0:Mushroom -> currentTile -> frontMushroom:Tile
		executeSetProperty(o0, "currentTile", o0.getCurrentTile(), frontMushroom);

		return true;

	}

	private Mushroom moveMushroomEast_findO0(Tile source) {
		Mushroom result = null;

		for (TileContent o0TileContent : source.getContents()) {

			if (!(o0TileContent instanceof Mushroom)) {
				continue;
			}
			Mushroom o0 = (Mushroom) o0TileContent;

			result = o0;
			break;
		}
		return result;
	}

	private boolean moveHamster() {

		boolean result;

		result = moveNorth();

		if (result) {

			return true;
		}

		result = moveSouth();

		if (result) {

			return true;
		}

		result = moveWest();

		if (result) {

			return true;
		}

		result = moveEast();

		if (result) {

			return true;
		}

		return false;

	}

	private boolean moveMushroom() {

		boolean result;

		result = moveMushroomNorth();

		if (result) {

			return true;
		}

		result = moveMushroomSouth();

		if (result) {

			return true;
		}

		result = moveMushroomWest();

		if (result) {

			return true;
		}

		result = moveMushroomEast();

		if (result) {

			return true;
		}

		result = acceptor();

		if (result) {

			return true;
		}

		return false;

	}

	private boolean acceptor() {

		return true;

	}

	private boolean addGameLog() {

		// new instance: entry:LogEntry
		LogEntry entry = new LogEntry();

		// set value type field entry.message := 
		executeSetProperty(entry, "message", entry.getMessage(), "Move");

		// create reference: CREATE entry:LogEntry -> actor -> self:GameHamster
		executeSetProperty(entry, "actor", entry.getActor(), self);

		// create reference: CREATE gameLog:GameLog -> logEntries -> entry:LogEntry
		executeAddReference(gameLog, "logEntries", entry);

		return true;

	}

}
