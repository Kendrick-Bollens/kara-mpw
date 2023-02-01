/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.facade;

import de.unistuttgart.iste.sqa.mpw.framework.mpw.*;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.*;
import de.unistuttgart.hamster.hamster.*;
import de.unistuttgart.hamster.commands.territory.*;

public class TerritoryBuilder {
	private EditorTerritory territory;
	private HamsterGame game;

	/**
	* Creates a new TerritoryBuilder object which then can be used to defined the given Territory.
	*/
	public TerritoryBuilder(HamsterGame game) {
		this.game = game;
		this.territory = game.getTerritory().getInternalEditorTerritory();
	}

	/**
	* Place a wall at the given location. The location has to be empty before a mushroom can be placed.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> location has to be on territory<br/>
	* <b>ensures:</b> a wall is placed on the tile on the tile location<br/>
	* <b>requires:</b> the tile at the given location has to be empty
	* 
	*/
	public TerritoryBuilder addMushroomToTile(Location location) {
		var parameters = new AddMushroomToTileCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.location = location;
		game.getPerformance().preExecuteEditorCommand();
		territory.addMushroomToTile(parameters);
		return this;
	}

	/**
	* Place a wall at the given location. The location has to be empty before a wall can be placed.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> the tile at the given location has to be empty<br/>
	* <b>ensures:</b> a wall is placed on the tile on the tile location<br/>
	* <b>requires:</b> location has to be on territory
	* 
	*/
	public TerritoryBuilder addWallToTile(Location location) {
		var parameters = new AddWallToTileCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.location = location;
		game.getPerformance().preExecuteEditorCommand();
		territory.addWallToTile(parameters);
		return this;
	}

	/**
	* Clears all contents of the tile identified by the given location.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> location has to be on territory<br/>
	* <b>ensures:</b> the tile's contents have to be empty
	* 
	*/
	public TerritoryBuilder clearTile(Location location) {
		var parameters = new ClearTileCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.location = location;
		game.getPerformance().preExecuteEditorCommand();
		territory.clearTile(parameters);
		return this;
	}

	/**
	* Initialize a hamster object with the given parameters. Once a hamster is initialized, the method must not be called again.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> hamster must not be already initialized<br/>
	* <b>requires:</b> location has to be on territory
	* 
	*/
	public TerritoryBuilder initDefaultHamster(Location location, Direction direction) {
		var parameters = new InitDefaultHamsterCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.location = location;
		parameters.direction = direction;
		game.getPerformance().preExecuteEditorCommand();
		territory.initDefaultHamster(parameters);
		return this;
	}

	/**
	* Defines a new territory by creating a new, empty territory of the given size.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> size must be > 0<br/>
	* <b>ensures:</b> size of territory is set
	* 
	*/
	public TerritoryBuilder initTerritory(int columns, int rows) {
		var parameters = new InitTerritoryCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.columns = columns;
		parameters.rows = rows;
		game.getPerformance().preExecuteEditorCommand();
		territory.initTerritory(parameters);
		return this;
	}

	/**
	* Place a wall at the given location. The location has to be empty before a mushroom can be placed.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> location has to be on territory<br/>
	* <b>ensures:</b> a wall is placed on the tile on the tile location<br/>
	* <b>requires:</b> the tile at the given location has to be empty
	* 
	*/
	public TerritoryBuilder addMushroomToTile(int locationX, int locationY) {
		var location = new Location(locationX, locationY);
		var parameters = new AddMushroomToTileCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.location = location;
		game.getPerformance().preExecuteEditorCommand();
		territory.addMushroomToTile(parameters);
		return this;
	}

	/**
	* Place a wall at the given location. The location has to be empty before a wall can be placed.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> the tile at the given location has to be empty<br/>
	* <b>ensures:</b> a wall is placed on the tile on the tile location<br/>
	* <b>requires:</b> location has to be on territory
	* 
	*/
	public TerritoryBuilder addWallToTile(int locationX, int locationY) {
		var location = new Location(locationX, locationY);
		var parameters = new AddWallToTileCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.location = location;
		game.getPerformance().preExecuteEditorCommand();
		territory.addWallToTile(parameters);
		return this;
	}

	/**
	* Clears all contents of the tile identified by the given location.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> location has to be on territory<br/>
	* <b>ensures:</b> the tile's contents have to be empty
	* 
	*/
	public TerritoryBuilder clearTile(int locationX, int locationY) {
		var location = new Location(locationX, locationY);
		var parameters = new ClearTileCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.location = location;
		game.getPerformance().preExecuteEditorCommand();
		territory.clearTile(parameters);
		return this;
	}

	/**
	* Initialize a hamster object with the given parameters. Once a hamster is initialized, the method must not be called again.<br/>
	* <br/>
	* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
	* <b>requires:</b> hamster must not be already initialized<br/>
	* <b>requires:</b> location has to be on territory
	* 
	*/
	public TerritoryBuilder initDefaultHamster(int locationX, int locationY, Direction direction) {
		var location = new Location(locationX, locationY);
		var parameters = new InitDefaultHamsterCommandParameters();
		parameters.commandStack = game.getEditorCommandStack();
		parameters.location = location;
		parameters.direction = direction;
		game.getPerformance().preExecuteEditorCommand();
		territory.initDefaultHamster(parameters);
		return this;
	}

}
