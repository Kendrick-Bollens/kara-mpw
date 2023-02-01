/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.hamster;

import de.unistuttgart.hamster.commands.hamster.*;
import static de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction.*;
import java.util.stream.Collectors;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Actor;
import de.unistuttgart.hamster.hamster.GameHamster;
import de.unistuttgart.hamster.hamster.EditorHamster;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Tile;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.Stage;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction;
import de.unistuttgart.hamster.hamster.ConcreteHamster;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Location;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.TileContent;
import de.unistuttgart.hamster.hamster.Clover;
import de.unistuttgart.hamster.hamster.Mushroom;
import de.unistuttgart.hamster.hamster.Wall;
import de.unistuttgart.hamster.hamster.GameTerritory;
import de.unistuttgart.hamster.hamster.ConcreteTerritory;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Size;

/**
* Class for Hamster in the Hamster Simulator. This class allows to initialize
* Hamsters, command Hamsters through their territory and query their state.
* 
* By deriving from Actor, a Hamster represents a TileContent which has a link to the parent Stage.
*/
public class ConcreteHamster extends Actor implements GameHamster, EditorHamster {

	public ConcreteHamster() {

	}

	@Override
	public Location getLocation() {
		try {
			return helperGetLocationCurrentTileResult0Location();
		} catch (Exception e) {
			return null;
		}
	}

	private Location helperGetLocationCurrentTileResult0Location() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return null;
		}
		Location result1 = result0.getLocation();
		return result1;
	}

	@Override
	public boolean cloverAvailable() {
		try {
			return helperCloverAvailableCurrentTileResult0ContentsTypeSelectCloverNotEmpty();
		} catch (Exception e) {
			return false;
		}
	}

	private boolean helperCloverAvailableCurrentTileResult0ContentsTypeSelectCloverNotEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		boolean result1 = result0.getContents().stream().filter(Clover.class::isInstance).map(Clover.class::cast)
				.collect(Collectors.toList()).size() > 0;
		return result1;
	}

	@Override
	public boolean behindMushroomIsClear() {
		try {
			return ((this.getDirection() == WEST)
					? (helperBehindMushroomIsClearCurrentTileResult0WestResult1ContentsTypeSelectMushroomNotEmpty())
					: true

							&& (this.getDirection() == EAST)
									? (helperBehindMushroomIsClearCurrentTileResult0EastResult1ContentsTypeSelectMushroomNotEmpty())
									: true

											&& (this.getDirection() == NORTH)
													? (helperBehindMushroomIsClearCurrentTileResult0NorthResult1ContentsTypeSelectMushroomNotEmpty())
													: true

															&& (this.getDirection() == SOUTH)
																	? (helperBehindMushroomIsClearCurrentTileResult0SouthResult1ContentsTypeSelectMushroomNotEmpty())
																	: true)
																			? ((this.getDirection() == WEST)
																					? (helperBehindMushroomIsClearCurrentTileResult0WestResult1WestResult2ContentsTypeSelectWallIsEmpty())
																					: true

																							&& (this.getDirection() == EAST)
																									? (helperBehindMushroomIsClearCurrentTileResult0EastResult1EastResult2ContentsTypeSelectWallIsEmpty())
																									: true

																											&& (this.getDirection() == NORTH)
																													? (helperBehindMushroomIsClearCurrentTileResult0NorthResult1NorthResult2ContentsTypeSelectWallIsEmpty())
																													: true

																															&& (this.getDirection() == SOUTH)
																																	? (helperBehindMushroomIsClearCurrentTileResult0SouthResult1SouthResult2ContentsTypeSelectWallIsEmpty())
																																	: true)
																			: true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean helperBehindMushroomIsClearCurrentTileResult0SouthResult1SouthResult2ContentsTypeSelectWallIsEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getSouth();
		if (result1 == null) {
			return false;
		}
		Tile result2 = result1.getSouth();
		if (result2 == null) {
			return false;
		}
		boolean result3 = result2.getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).isEmpty();
		return result3;
	}

	private boolean helperBehindMushroomIsClearCurrentTileResult0WestResult1WestResult2ContentsTypeSelectWallIsEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getWest();
		if (result1 == null) {
			return false;
		}
		Tile result2 = result1.getWest();
		if (result2 == null) {
			return false;
		}
		boolean result3 = result2.getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).isEmpty();
		return result3;
	}

	private boolean helperBehindMushroomIsClearCurrentTileResult0SouthResult1ContentsTypeSelectMushroomNotEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getSouth();
		if (result1 == null) {
			return false;
		}
		boolean result2 = result1.getContents().stream().filter(Mushroom.class::isInstance).map(Mushroom.class::cast)
				.collect(Collectors.toList()).size() > 0;
		return result2;
	}

	private boolean helperBehindMushroomIsClearCurrentTileResult0NorthResult1NorthResult2ContentsTypeSelectWallIsEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getNorth();
		if (result1 == null) {
			return false;
		}
		Tile result2 = result1.getNorth();
		if (result2 == null) {
			return false;
		}
		boolean result3 = result2.getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).isEmpty();
		return result3;
	}

	private boolean helperBehindMushroomIsClearCurrentTileResult0EastResult1EastResult2ContentsTypeSelectWallIsEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getEast();
		if (result1 == null) {
			return false;
		}
		Tile result2 = result1.getEast();
		if (result2 == null) {
			return false;
		}
		boolean result3 = result2.getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).isEmpty();
		return result3;
	}

	private boolean helperBehindMushroomIsClearCurrentTileResult0NorthResult1ContentsTypeSelectMushroomNotEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getNorth();
		if (result1 == null) {
			return false;
		}
		boolean result2 = result1.getContents().stream().filter(Mushroom.class::isInstance).map(Mushroom.class::cast)
				.collect(Collectors.toList()).size() > 0;
		return result2;
	}

	private boolean helperBehindMushroomIsClearCurrentTileResult0WestResult1ContentsTypeSelectMushroomNotEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getWest();
		if (result1 == null) {
			return false;
		}
		boolean result2 = result1.getContents().stream().filter(Mushroom.class::isInstance).map(Mushroom.class::cast)
				.collect(Collectors.toList()).size() > 0;
		return result2;
	}

	private boolean helperBehindMushroomIsClearCurrentTileResult0EastResult1ContentsTypeSelectMushroomNotEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getEast();
		if (result1 == null) {
			return false;
		}
		boolean result2 = result1.getContents().stream().filter(Mushroom.class::isInstance).map(Mushroom.class::cast)
				.collect(Collectors.toList()).size() > 0;
		return result2;
	}

	@Override
	public boolean frontIsClear() {
		try {
			return (this.getDirection() == WEST)
					? (helperFrontIsClearCurrentTileResult0WestResult1ContentsTypeSelectWallIsEmpty())
					: true

							&& (this.getDirection() == EAST)
									? (helperFrontIsClearCurrentTileResult0EastResult1ContentsTypeSelectWallIsEmpty())
									: true

											&& (this.getDirection() == NORTH)
													? (helperFrontIsClearCurrentTileResult0NorthResult1ContentsTypeSelectWallIsEmpty())
													: true

															&& (this.getDirection() == SOUTH)
																	? (helperFrontIsClearCurrentTileResult0SouthResult1ContentsTypeSelectWallIsEmpty())
																	: true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean helperFrontIsClearCurrentTileResult0SouthResult1ContentsTypeSelectWallIsEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getSouth();
		if (result1 == null) {
			return false;
		}
		boolean result2 = result1.getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).isEmpty();
		return result2;
	}

	private boolean helperFrontIsClearCurrentTileResult0WestResult1ContentsTypeSelectWallIsEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getWest();
		if (result1 == null) {
			return false;
		}
		boolean result2 = result1.getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).isEmpty();
		return result2;
	}

	private boolean helperFrontIsClearCurrentTileResult0EastResult1ContentsTypeSelectWallIsEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getEast();
		if (result1 == null) {
			return false;
		}
		boolean result2 = result1.getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).isEmpty();
		return result2;
	}

	private boolean helperFrontIsClearCurrentTileResult0NorthResult1ContentsTypeSelectWallIsEmpty() {
		Tile result0 = this.getCurrentTile();
		if (result0 == null) {
			return false;
		}
		Tile result1 = result0.getNorth();
		if (result1 == null) {
			return false;
		}
		boolean result2 = result1.getContents().stream().filter(Wall.class::isInstance).map(Wall.class::cast)
				.collect(Collectors.toList()).isEmpty();
		return result2;
	}

	@Override
	public void initHamster(InitHamsterCommandParameters parameters) {
		parameters.self = this;
		var command = new InitHamsterCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void move(MoveCommandParameters parameters) {
		parameters.self = this;
		var command = new MoveCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void pickClover(PickCloverCommandParameters parameters) {
		parameters.self = this;
		var command = new PickCloverCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void putClover(PutCloverCommandParameters parameters) {
		parameters.self = this;
		var command = new PutCloverCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void turnLeft(TurnLeftCommandParameters parameters) {
		parameters.self = this;
		var command = new TurnLeftCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void turnRight(TurnRightCommandParameters parameters) {
		parameters.self = this;
		var command = new TurnRightCommand(parameters);
		parameters.commandStack.execute(command);
	}

	@Override
	public void write(WriteCommandParameters parameters) {
		parameters.self = this;
		var command = new WriteCommand(parameters);
		parameters.commandStack.execute(command);
	}

}
