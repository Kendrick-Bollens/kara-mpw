/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.hamster;

import de.unistuttgart.hamster.commands.hamster.*;
import de.unistuttgart.hamster.hamster.ReadOnlyHamster;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Location;
import de.unistuttgart.hamster.hamster.GameTerritory;
import de.unistuttgart.hamster.hamster.ConcreteHamster;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Stage;
import de.unistuttgart.hamster.hamster.ConcreteTerritory;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Tile;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Size;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.TileContent;
import de.unistuttgart.hamster.hamster.Wall;
import de.unistuttgart.hamster.hamster.Mushroom;
import de.unistuttgart.hamster.hamster.Clover;

public interface GameHamster extends ReadOnlyHamster {

	void initHamster(InitHamsterCommandParameters parameters);

	void move(MoveCommandParameters parameters);

	void pickClover(PickCloverCommandParameters parameters);

	void putClover(PutCloverCommandParameters parameters);

	void turnLeft(TurnLeftCommandParameters parameters);

	void turnRight(TurnRightCommandParameters parameters);

	void write(WriteCommandParameters parameters);

}
