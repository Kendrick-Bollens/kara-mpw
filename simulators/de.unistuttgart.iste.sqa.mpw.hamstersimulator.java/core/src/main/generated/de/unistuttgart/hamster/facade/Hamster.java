/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.facade;

import de.unistuttgart.iste.sqa.mpw.framework.mpw.*;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.*;
import de.unistuttgart.hamster.hamster.*;
import de.unistuttgart.hamster.commands.hamster.*;

/**
* Class for Hamster in the Hamster Simulator. This class allows to initialize
* Hamsters, command Hamsters through their territory and query their state.
* 
* By deriving from Actor, a Hamster represents a TileContent which has a link to the parent Stage.
*/
public class Hamster {
	private HamsterGame game;
	private ConcreteHamster internalHamster;

	/**
	* Create a new Hamster object without initializing it.
	*/
	public Hamster() {
		this.internalHamster = new ConcreteHamster();
	}

	/**
	* Create a new Hamster object by initializing it with the relating init() method.
	*/
	public Hamster(Territory territory, Location location, Direction direction) {
		this.internalHamster = new ConcreteHamster();
		this.init(territory, location, direction);
	}

	/**
	* Internal constructor.
	*/
	public Hamster(HamsterGame game, ConcreteHamster internalHamster) {
		this.internalHamster = internalHamster;
		this.game = game;
	}

	/**
	* Initialize a hamster object with the given parameters. Once a hamster is initialized, the method must not be called again.<br/>
	* <br/>
	* <b>requires / ensures:</b> the hamster is placed on a tile.<br/>
	* <b>requires:</b> the hamster must not be already initialized<br/>
	* <b>requires:</b> location has to be on territory
	* 
	*/
	public void init(Territory territory, Location location, Direction direction) {
		this.game = territory.getGame();
		var gameTerritory = territory.getInternalTerritory();
		var parameters = new InitHamsterCommandParameters();
		parameters.commandStack = game.getGameCommandStack();
		parameters.gameLog = game.getGameLog();
		parameters.territory = gameTerritory;
		parameters.location = location;
		parameters.direction = direction;
		game.getPerformance().preExecuteGameCommand();
		try {
			internalHamster.initHamster(parameters);
			game.getPerformance().delayControlFlow();
		} catch (Exception e) {
			// Stop the game to prevent execution of further commands!
			game.getPerformance().setMode(Mode.STOPPED);
			throw e;
		}
	}

	public void move() {
		var parameters = new MoveCommandParameters();
		parameters.commandStack = game.getGameCommandStack();
		parameters.gameLog = game.getGameLog();
		game.getPerformance().preExecuteGameCommand();
		try {
			internalHamster.move(parameters);
			game.getPerformance().delayControlFlow();
		} catch (Exception e) {
			// Stop the game to prevent execution of further commands!
			game.getPerformance().setMode(Mode.STOPPED);
			throw e;
		}
	}

	/**
	* <br/>
	* <br/>
	* <b>requires / ensures:</b> the hamster is placed on a tile.<br/>
	* <b>ensures:</b> on the current tile, now only the hamster has to be contained<br/>
	* <b>requires:</b> on the current tile, a breadcrumb has to be contained
	* 
	*/
	public void pickClover() {
		var parameters = new PickCloverCommandParameters();
		parameters.commandStack = game.getGameCommandStack();
		parameters.gameLog = game.getGameLog();
		game.getPerformance().preExecuteGameCommand();
		try {
			internalHamster.pickClover(parameters);
			game.getPerformance().delayControlFlow();
		} catch (Exception e) {
			// Stop the game to prevent execution of further commands!
			game.getPerformance().setMode(Mode.STOPPED);
			throw e;
		}
	}

	/**
	* <br/>
	* <br/>
	* <b>requires / ensures:</b> the hamster is placed on a tile.<br/>
	* <b>requires:</b> on the current tile, only the hamster has to be contained<br/>
	* <b>ensures:</b> on the current tile, now also a breadcrumb has to be contained
	* 
	*/
	public void putClover() {
		var parameters = new PutCloverCommandParameters();
		parameters.commandStack = game.getGameCommandStack();
		parameters.gameLog = game.getGameLog();
		game.getPerformance().preExecuteGameCommand();
		try {
			internalHamster.putClover(parameters);
			game.getPerformance().delayControlFlow();
		} catch (Exception e) {
			// Stop the game to prevent execution of further commands!
			game.getPerformance().setMode(Mode.STOPPED);
			throw e;
		}
	}

	/**
	* Changes the looking direction 90 degrees to the left, e.g., when looking north the hamster will look towards west afterwards.<br/>
	* <br/>
	* <b>requires / ensures:</b> the hamster is placed on a tile.
	* 
	*/
	public void turnLeft() {
		var parameters = new TurnLeftCommandParameters();
		parameters.commandStack = game.getGameCommandStack();
		parameters.gameLog = game.getGameLog();
		game.getPerformance().preExecuteGameCommand();
		try {
			internalHamster.turnLeft(parameters);
			game.getPerformance().delayControlFlow();
		} catch (Exception e) {
			// Stop the game to prevent execution of further commands!
			game.getPerformance().setMode(Mode.STOPPED);
			throw e;
		}
	}

	/**
	* <br/>
	* <br/>
	* <b>requires / ensures:</b> the hamster is placed on a tile.
	* 
	*/
	public void turnRight() {
		var parameters = new TurnRightCommandParameters();
		parameters.commandStack = game.getGameCommandStack();
		parameters.gameLog = game.getGameLog();
		game.getPerformance().preExecuteGameCommand();
		try {
			internalHamster.turnRight(parameters);
			game.getPerformance().delayControlFlow();
		} catch (Exception e) {
			// Stop the game to prevent execution of further commands!
			game.getPerformance().setMode(Mode.STOPPED);
			throw e;
		}
	}

	/**
	* Writes a new string for this actor to the game log. The message
	* will be displayed in a way that it can be associated to this object.
	*/
	public void write(String message) {
		var parameters = new WriteCommandParameters();
		parameters.commandStack = game.getGameCommandStack();
		parameters.gameLog = game.getGameLog();
		parameters.message = message;
		game.getPerformance().preExecuteGameCommand();
		try {
			internalHamster.write(parameters);
			game.getPerformance().delayControlFlow();
		} catch (Exception e) {
			// Stop the game to prevent execution of further commands!
			game.getPerformance().setMode(Mode.STOPPED);
			throw e;
		}
	}

	/**
	* Get the current hamster looking direction.
	*/
	public Direction getDirection() {
		return internalHamster.getDirection();
	}

	/**
	* Checks the if a mushroom is in front that behind it it is free
	*/
	public boolean behindMushroomIsClear() {
		return internalHamster.behindMushroomIsClear();
	}

	/**
	* Checks the front of the hamster.
	*/
	public boolean frontIsClear() {
		return internalHamster.frontIsClear();
	}

	/**
	* Get the current hamster location.
	*/
	public Location getLocation() {
		return internalHamster.getLocation();
	}

	/**
	* Checks the hamster's current tile for a breadcrumb.
	*/
	public boolean cloverAvailable() {
		return internalHamster.cloverAvailable();
	}

	/**
	* Read a number from the simulator UI for further use.
	*/
	public int readNumber(String message) {
		var gameInterface = game.getUserInputInterface();
		var result = gameInterface.readInteger(message);
		return result;
	}

	/**
	* Read a string from the simulator UI for further use.
	*/
	public String readString(String message) {
		var gameInterface = game.getUserInputInterface();
		var result = gameInterface.readString(message);
		return result;
	}

	/**
	* Get the internal game representation of the Hamster.
	*/
	public GameHamster getInternalHamster() {
		return this.internalHamster;
	}

	/**
	* Get the internal editor representation of the Hamster.
	*/
	public EditorHamster getInternalEditorHamster() {
		return this.internalHamster;
	}

}
