/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.hamster;

import javafx.beans.property.*;
import de.unistuttgart.iste.sqa.mpw.framework.basetypes.Entity;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Tile;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Stage;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction;
import de.unistuttgart.hamster.hamster.ConcreteHamster;
import de.unistuttgart.hamster.hamster.Wall;
import de.unistuttgart.hamster.hamster.Mushroom;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.TileContent;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Location;
import de.unistuttgart.hamster.hamster.Clover;

public interface ReadOnlyHamster extends Entity {

	Tile getCurrentTile();
	ReadOnlyObjectProperty<Tile> currentTileProperty();

	Stage getStage();
	ReadOnlyObjectProperty<Stage> stageProperty();

	/**
	* Get the current hamster looking direction.
	*/
	Direction getDirection();
	ReadOnlyObjectProperty<Direction> directionProperty();

	/**
	* Checks the if a mushroom is in front that behind it it is free
	*/
	boolean behindMushroomIsClear();

	/**
	* Checks the front of the hamster.
	*/
	boolean frontIsClear();

	/**
	* Get the current hamster location.
	*/
	Location getLocation();

	/**
	* Checks the hamster's current tile for a breadcrumb.
	*/
	boolean cloverAvailable();

}
