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
* Clears all contents of the tile identified by the given location.<br/>
* <br/>
* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
* <b>requires:</b> location has to be on territory<br/>
* <b>ensures:</b> the tile's contents have to be empty
* 
*/

public class ClearTileCommand extends CompositeCommandBase {
	private final ConcreteTerritory self;

	private final Location location;

	public ClearTileCommand(ClearTileCommandParameters parameters) {
		this.self = parameters.self;
		this.location = parameters.location;
	}

	@Override
	public void execute() {

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
			throw new RuntimeException("Transformation was not successfully executed: clearTile");
		}

		/*
		* the tile's contents have to be empty
		*/

		if ((self.getTileAt(location).getContents().isEmpty()) == false) {
			throw new CommandConstraintException("Violation of Postcondition: the tile's contents have to be empty");
		}

		/*
		* the territory tiles must not be empty
		*/

		if ((self.getTiles().size() > 0) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the territory tiles must not be empty");
		}

	}
	private boolean internalMainUnit() {

		// find new variable from many-reference: self:EditorTerritory -> tiles -> o0:Tile

		Tile o0 = execute_findO0(self);
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

		// clear references: o0:Tile -> contents -> o2:TileContent
		while (o0.getContents().size() > 0) {
			executeRemoveReference(o0, "contents", o0.getContents().get(0));
		}

		// clear references: self:EditorTerritory -> tileContents -> o2:TileContent
		while (self.getTileContents().size() > 0) {
			executeRemoveReference(self, "tileContents", self.getTileContents().get(0));
		}

		return true;

	}

	private Tile execute_findO0(EditorTerritory source) {
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
