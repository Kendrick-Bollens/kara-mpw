/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.facade;

import de.unistuttgart.iste.sqa.mpw.framework.datatypes.*;
import de.unistuttgart.hamster.hamster.*;

/**
* The territory is a Stage which represents territories for hamsters. Territories
* are rectangular areas with width and height composed out of territory
* tiles. Tiles again can contain hamster objects, grain objects, or walls.
*/
public class Territory {
	private HamsterGame game;
	private ConcreteTerritory internalTerritory;
	private Hamster defaultHamster;

	/**
	* Initialize a new Territory and link it to its game object.
	*/
	public Territory(HamsterGame game) {
		this.internalTerritory = new ConcreteTerritory();
		this.game = game;
		this.defaultHamster = new Hamster(game, internalTerritory.getDefaultHamster());
	}

	/**
	* Return the size of the current territory. From the size you can retrieve the number of rows and colums.
	*/
	public Size getTerritorySize() {
		return internalTerritory.getTerritorySize();
	}

	/**
	* For a given location, tests whether the location is inside the bound of the territory.
	*/
	public boolean isLocationInTerritory(Location location) {
		return internalTerritory.isLocationInTerritory(location);
	}

	/**
	* Get the internal game representation of the Territory.
	*/
	public GameTerritory getInternalTerritory() {
		return this.internalTerritory;
	}

	/**
	* Get the internal editor representation of the Territory.
	*/
	public EditorTerritory getInternalEditorTerritory() {
		return this.internalTerritory;
	}

	public Hamster getDefaultHamster() {
		return this.defaultHamster;
	}

	/**
	* Gets the game associated to this Territory object.
	*/
	public HamsterGame getGame() {
		return this.game;
	}

}
