/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.facade;

import de.unistuttgart.hamster.facade.Territory;
import de.unistuttgart.iste.sqa.mpw.framework.facade.MiniProgrammingWorld;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.GamePerformance;
import de.unistuttgart.iste.sqa.mpw.framework.mpw.UserInputInterface;
import de.unistuttgart.iste.sqa.mpw.framework.commands.CommandStack;

/**
* A MiniProgrammingWorld representing an instance of a hamster game. A hamster game consists of a territory, on
* which the game takes place, a game log for messages, and a command stack for keeping track of the
* game's history.
*/
public class HamsterGame extends MiniProgrammingWorld {

	private final Territory territory = new Territory(this);

	public HamsterGame() {

	}

	public Territory getTerritory() {
		return this.territory;
	}

	/**
	* Start the execution of a game. Before executing start, no commands can be
	* executed by the actor objects in the game.
	* This is only possible if the current mode is Mode.INITIALIZING
	* The game will be started in running mode.
	*/
	public void startGame() {
		var performance = getPerformance();
		performance.startGame();
	}

	/**
	* Start the execution of a game. Before executing start, no commands can be
	* executed by the actor objects in the game.
	* This is only possible if the current mode is Mode.INITIALIZING
	* The game will be started in pause mode.
	*/
	public void startGamePaused() {
		var performance = getPerformance();
		performance.startGamePaused();
	}

	/**
	* Hard-resets the game command stack. It clears executed commands and undone commands, however, it does NOT
	* undo all commands. If this behaviour is desired, it is necessary to call undoAll first.
	* This also sets the mode to initializing.
	*/
	public void hardReset() {
		var performance = getPerformance();
		performance.hardReset();
	}

	/**
	* Stop the execution of the game. The game is finished and needs to be reset / hardReset
	* or closed.
	* If the game is already stopped, this does nothing
	*/
	public void stopGame() {
		var performance = getPerformance();
		performance.stopGame();
	}

	/**
	* Pauses the game when it is running.
	* If the game is not running (paused previously, not started or stopped), an exception
	* is thrown.
	* This is executed asynchronously, but this method waits until the started thread
	* has performed a paused state.
	*/
	public void pauseGame() {
		var performance = getPerformance();
		performance.pauseGame();
	}

	/**
	* Resumes the game.
	* It is only possible to execute this in paused mode.
	*/
	public void resumeGame() {
		var performance = getPerformance();
		performance.resumeGame();
	}

	/**
	* Inform a user about an abnormal execution aborting.
	* This blocks until it returns or is aborted
	* This must be thread safe
	* @param t The throwable which lead to aborting the program.
	*/
	public void confirmAlert(Throwable t) {
		var userInputInterface = getUserInputInterface();
		userInputInterface.confirmAlert(t);
	}

	public CommandStack getGameCommandStack() {
		var performance = getPerformance();
		return performance.getGameCommandStack();
	}

}
