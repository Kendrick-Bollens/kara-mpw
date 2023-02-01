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
* Place a wall at the given location. The location has to be empty before a wall can be placed.<br/>
* <br/>
* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
* <b>requires:</b> the tile at the given location has to be empty<br/>
* <b>ensures:</b> a wall is placed on the tile on the tile location<br/>
* <b>requires:</b> location has to be on territory
* 
*/

public class AddWallToTileCommand extends CompositeCommandBase {
	private final ConcreteTerritory self;

	private final Location location;

	public AddWallToTileCommand(AddWallToTileCommandParameters parameters) {
		this.self = parameters.self;
		this.location = parameters.location;
	}

	@Override
	public void execute() {

		/*
		* the tile at the given location has to be empty
		*/

		if ((self.getTileAt(location).getContents().isEmpty()) == false) {
			throw new CommandConstraintException(
					"Violation of Precondition: the tile at the given location has to be empty");
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
			throw new RuntimeException("Transformation was not successfully executed: addWallToTile");
		}

		/*
		* a wall is placed on the tile on the tile location
		*/

		if ((self.getTileAt(location).getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).size() == 1) == false) {
			throw new CommandConstraintException(
					"Violation of Postcondition: a wall is placed on the tile on the tile location");
		}

		/*
		* the territory tiles must not be empty
		*/

		if ((self.getTiles().size() > 0) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the territory tiles must not be empty");
		}

	}
	private boolean internalMainUnit() {

		// new instance: o2:Wall
		Wall o2 = new Wall();

		// find new variable from many-reference: self:EditorTerritory -> tiles -> o1:Tile

		Tile o1 = execute_findO1(self);
		if (o1 == null) {
			return false;
		}

		// new variable from reference: o1:Tile -> location -> o0:Location

		Location o0 = o1.getLocation();
		if (o0 == null) {
			return false;
		}

		// assert condition: o0.column == location.column
		if (o0.getColumn() != location.getColumn()) {
			return false;
		}

		// assert condition: o0.row == location.row
		if (o0.getRow() != location.getRow()) {
			return false;
		}

		// create reference: CREATE o1:Tile -> contents -> o2:Wall
		executeAddReference(o1, "contents", o2);

		// create reference: CREATE self:EditorTerritory -> tileContents -> o2:Wall
		executeAddReference(self, "tileContents", o2);

		return true;

	}

	private Tile execute_findO1(EditorTerritory source) {
		Tile result = null;

		for (Tile o1 : source.getTiles()) {

			// reference check: o1: location

			Location o0 = o1.getLocation();
			if (o0 == null) {

				continue;
			}

			// attribute check: o0: column
			if (o0.getColumn() != location.getColumn()) {
				continue;
			}

			// attribute check: o0: row
			if (o0.getRow() != location.getRow()) {
				continue;
			}

			result = o1;
			break;
		}
		return result;
	}

}
