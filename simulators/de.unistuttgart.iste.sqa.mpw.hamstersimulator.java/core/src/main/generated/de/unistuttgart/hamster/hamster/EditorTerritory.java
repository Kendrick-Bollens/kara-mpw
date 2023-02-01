/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.hamster;

import de.unistuttgart.hamster.commands.territory.*;
import de.unistuttgart.hamster.hamster.ReadOnlyTerritory;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Location;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Tile;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.TileContent;
import de.unistuttgart.hamster.hamster.ConcreteTerritory;
import de.unistuttgart.hamster.hamster.Mushroom;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Size;
import de.unistuttgart.hamster.hamster.Wall;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Stage;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction;
import de.unistuttgart.hamster.hamster.ConcreteHamster;

public interface EditorTerritory extends ReadOnlyTerritory {

	void addMushroomToTile(AddMushroomToTileCommandParameters parameters);

	void addWallToTile(AddWallToTileCommandParameters parameters);

	void clearTile(ClearTileCommandParameters parameters);

	void initDefaultHamster(InitDefaultHamsterCommandParameters parameters);

	void initTerritory(InitTerritoryCommandParameters parameters);

	EditorHamster getEditorDefaultHamster();

}
