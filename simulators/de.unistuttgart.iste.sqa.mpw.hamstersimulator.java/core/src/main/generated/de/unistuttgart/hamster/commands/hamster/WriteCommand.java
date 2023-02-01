/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.commands.hamster;

import static de.unistuttgart.iste.sqa.mpw.framework.FrameworkAssert.*;
import de.unistuttgart.iste.sqa.mpw.framework.exceptions.*;
import de.unistuttgart.hamster.hamster.*;

import de.unistuttgart.iste.sqa.mpw.framework.mpw.*;
import de.unistuttgart.iste.sqa.mpw.framework.commands.*;
import de.unistuttgart.iste.sqa.mpw.framework.commands.impl.*;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.*;
import static de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction.*;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction.*;
import de.unistuttgart.iste.sqa.mpw.framework.utils.*;
import java.util.stream.Collectors;

/**
* Writes a new string for this actor to the game log. The message
* will be displayed in a way that it can be associated to this object.
*/

public class WriteCommand extends CompositeCommandBase {
	private final ConcreteHamster self;
	private final GameLog gameLog;

	private final String message;

	public WriteCommand(WriteCommandParameters parameters) {
		this.self = parameters.self;
		this.gameLog = parameters.gameLog;
		this.message = parameters.message;
	}

	@Override
	public void execute() {

		if (!internalMainUnit()) {
			throw new RuntimeException("Transformation was not successfully executed: write");
		}

	}
	private boolean internalMainUnit() {

		// new instance: entry:LogEntry
		LogEntry entry = new LogEntry();

		// set value type field entry.message := 
		executeSetProperty(entry, "message", entry.getMessage(), message);

		// create reference: CREATE entry:LogEntry -> actor -> self:GameHamster
		executeSetProperty(entry, "actor", entry.getActor(), self);

		// create reference: CREATE gameLog:GameLog -> logEntries -> entry:LogEntry
		executeAddReference(gameLog, "logEntries", entry);

		return true;

	}

}
