/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.hamster;

import de.unistuttgart.hamster.commands.territory.*;
import static de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction.*;
import java.util.stream.Collectors;
import de.unistuttgart.hamster.hamster.ConcreteHamster;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Stage;
import de.unistuttgart.hamster.hamster.GameTerritory;
import de.unistuttgart.hamster.hamster.EditorTerritory;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Tile;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.TileContent;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Size;
import de.unistuttgart.hamster.hamster.ConcreteTerritory;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Location;
import de.unistuttgart.hamster.hamster.Mushroom;
import de.unistuttgart.hamster.hamster.Wall;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction;

/**
* The territory is a Stage which represents territories for hamsters. Territories
* are rectangular areas with width and height composed out of territory
* tiles. Tiles again can contain hamster objects, grain objects, or walls.
*/
public class ConcreteTerritory extends Stage implements GameTerritory, EditorTerritory {

	/**
	* Reference to the default hamster of this territory.
	*/
	private final ConcreteHamster defaultHamster = new ConcreteHamster();

	public ConcreteTerritory() {

	}

	@Override
	public Size getTerritorySize() {
		try {
			return this.getStageSize();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public boolean isLocationInTerritory(Location location) {
		try {
			return location.getColumn() >= 0 && location.getColumn() < this.getStageSize().getColumnCount()

					&& location.getRow() >= 0 && location.getRow() < this.getStageSize().getRowCount();
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Tile getTileAt(Location location) {
		try {
			return this.getTiles().get(location.getRow() * this.getStageSize().getColumnCount() + location.getColumn());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void addMushroomToTile(AddMushroomToTileCommandParameters parameters) {
		parameters.self = this;
		var command = new AddMushroomToTileCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void addWallToTile(AddWallToTileCommandParameters parameters) {
		parameters.self = this;
		var command = new AddWallToTileCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void clearTile(ClearTileCommandParameters parameters) {
		parameters.self = this;
		var command = new ClearTileCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void initDefaultHamster(InitDefaultHamsterCommandParameters parameters) {
		parameters.self = this;
		var command = new InitDefaultHamsterCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void initTerritory(InitTerritoryCommandParameters parameters) {
		parameters.self = this;
		var command = new InitTerritoryCommand(parameters);
		parameters.commandStack.execute(command);
	}

	public ConcreteHamster getDefaultHamster() {
		return this.defaultHamster;
	}

	@Override
	public ReadOnlyHamster getReadOnlyDefaultHamster() {
		return this.defaultHamster;
	}

	@Override
	public GameHamster getGameDefaultHamster() {
		return this.defaultHamster;
	}

	@Override
	public EditorHamster getEditorDefaultHamster() {
		return this.defaultHamster;
	}

}
