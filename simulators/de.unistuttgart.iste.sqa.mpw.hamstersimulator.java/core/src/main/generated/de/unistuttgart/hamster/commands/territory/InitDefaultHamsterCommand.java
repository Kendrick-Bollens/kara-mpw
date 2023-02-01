/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.commands.territory;

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
* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
* <b>requires:</b> hamster must not be already initialized<br/>
* <b>requires:</b> location has to be on territory
* 
*/

public class InitDefaultHamsterCommand extends CompositeCommandBase {
	private final ConcreteTerritory self;

	private final Location location;

	private final Direction direction;

	public InitDefaultHamsterCommand(InitDefaultHamsterCommandParameters parameters) {
		this.self = parameters.self;
		this.location = parameters.location;
		this.direction = parameters.direction;
	}

	@Override
	public void execute() {

		/*
		* hamster must not be already initialized
		*/

		if ((self.getDefaultHamster().getStage() == null) == false) {
			throw new CommandConstraintException("Violation of Precondition: hamster must not be already initialized");
		}

		/*
		* location has to be on territory
		*/

		if ((self.isLocationInTerritory(location)) == false) {
			throw new CommandConstraintException("Violation of Precondition: location has to be on territory");
		}

		/*
		* the territory tiles must not be empty
		*/

		if ((self.getTiles().size() > 0) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the territory tiles must not be empty");
		}

		if (!internalMainUnit()) {
			throw new RuntimeException("Transformation was not successfully executed: initDefaultHamster");
		}

		/*
		* the territory tiles must not be empty
		*/

		if ((self.getTiles().size() > 0) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the territory tiles must not be empty");
		}

	}
	private boolean internalMainUnit() {

		boolean result;

		result = addToTerritory(location);

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

		// new variable from reference: self:EditorTerritory -> defaultHamster -> defaultHamster:EditorHamster

		EditorHamster defaultHamster = (self.getDefaultHamster() instanceof EditorHamster)
				? (EditorHamster) self.getDefaultHamster()
				: null;
		if (defaultHamster == null) {
			return false;
		}

		// set value type field defaultHamster.direction := initialDirection
		executeSetProperty(defaultHamster, "direction", defaultHamster.getDirection(), initialDirection);

		return true;

	}

	private boolean addToTerritory(Location location) {

		// new variable from reference: self:EditorTerritory -> defaultHamster -> defaultHamster:EditorHamster

		EditorHamster defaultHamster = (self.getDefaultHamster() instanceof EditorHamster)
				? (EditorHamster) self.getDefaultHamster()
				: null;
		if (defaultHamster == null) {
			return false;
		}

		// find new variable from many-reference: self:EditorTerritory -> tiles -> o0:Tile

		Tile o0 = addToTerritory_findO0(self);
		if (o0 == null) {
			return false;
		}

		// new variable from reference: o0:Tile -> location -> o1:Location

		Location o1 = o0.getLocation();
		if (o1 == null) {
			return false;
		}

		// assert condition: o1.column == location.column
		if (o1.getColumn() != location.getColumn()) {
			return false;
		}

		// assert condition: o1.row == location.row
		if (o1.getRow() != location.getRow()) {
			return false;
		}

		// create reference: CREATE self:EditorTerritory -> tileContents -> defaultHamster:EditorHamster
		executeAddReference(self, "tileContents", defaultHamster);

		// create reference: CREATE defaultHamster:EditorHamster -> currentTile -> o0:Tile
		executeSetProperty(defaultHamster, "currentTile", defaultHamster.getCurrentTile(), o0);

		return true;

	}

	private Tile addToTerritory_findO0(EditorTerritory source) {
		Tile result = null;

		for (Tile o0 : source.getTiles()) {

			// reference check: o0: location

			Location o1 = o0.getLocation();
			if (o1 == null) {

				continue;
			}

			// attribute check: o1: column
			if (o1.getColumn() != location.getColumn()) {
				continue;
			}

			// attribute check: o1: row
			if (o1.getRow() != location.getRow()) {
				continue;
			}

			result = o0;
			break;
		}
		return result;
	}

}
