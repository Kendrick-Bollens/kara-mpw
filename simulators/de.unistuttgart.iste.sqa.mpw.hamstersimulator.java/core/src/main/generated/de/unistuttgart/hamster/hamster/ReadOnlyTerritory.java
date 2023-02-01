/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.hamster;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javafx.beans.property.*;
import de.unistuttgart.iste.sqa.mpw.framework.basetypes.Entity;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Tile;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.TileContent;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Size;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Location;
import de.unistuttgart.hamster.hamster.ConcreteTerritory;

public interface ReadOnlyTerritory extends Entity {

	List<Tile> getTiles();
	ReadOnlyListProperty<Tile> tilesProperty();

	List<TileContent> getTileContents();
	ReadOnlyListProperty<TileContent> tileContentsProperty();

	Size getStageSize();
	ReadOnlyObjectProperty<Size> stageSizeProperty();

	/**
	* For a given location, tests whether the location is inside the bound of the territory.
	*/
	boolean isLocationInTerritory(Location location);

	/**
	* Return the size of the current territory. From the size you can retrieve the number of rows and colums.
	*/
	Size getTerritorySize();

	/**
	* For a given location, return the internal tile object.
	*/
	Tile getTileAt(Location location);

	ReadOnlyHamster getReadOnlyDefaultHamster();

}
