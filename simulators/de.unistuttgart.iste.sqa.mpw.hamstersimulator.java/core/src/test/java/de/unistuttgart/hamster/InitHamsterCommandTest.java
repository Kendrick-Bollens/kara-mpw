package de.unistuttgart.hamster;

import de.unistuttgart.iste.sqa.mpw.framework.exceptions.CommandConstraintException;
import de.unistuttgart.hamster.facade.HamsterGame;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Location;
import de.unistuttgart.hamster.util.GameStringifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InitHamsterCommandTest {
	
	@Test
	public void testInitHamsterOn1x1_and4() {
		HamsterGame game = GameStringifier.createFromStringStarted("   ;" +
															       "   ;");

		var sut = game.getTerritory().getDefaultHamster();
		sut.init(game.getTerritory(), locationOf(1, 1), Direction.SOUTH);

		String actual = GameStringifier.toString(game);
		assertEquals("   ;" +
				     " v ;", actual);

	}




	@Test
	public void testUndoInitHamster() {
		HamsterGame game = GameStringifier.createFromStringStarted("  ;");

		var sut = game.getTerritory().getDefaultHamster();
		sut.init(game.getTerritory(), locationOf(0, 0), Direction.SOUTH);
		game.getGameCommandStack().undo();

		assertEquals(null, sut.getInternalHamster().getDirection());

	}

	private Location locationOf(int column, int row) {
		var location = new Location();
		location.setColumn(column);
		location.setRow(row);
		return location;
	}


}
