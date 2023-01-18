package de.unistuttgart.hamster;

import de.unistuttgart.hamster.facade.HamsterGame;
import de.unistuttgart.hamster.facade.TerritoryBuilder;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Direction;
import de.unistuttgart.iste.sqa.mpw.framework.datatypes.Location;
import de.unistuttgart.hamster.util.GameStringifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TerritoryBuilderTest {
	private HamsterGame game;
	private TerritoryBuilder sut;
	
	@Test
	public void givenEmptyTerritory_whenInitializeTo5x3_thenHas5Rows_and3Columns_andAllAreEmpty() {
		withTerritoryBuilder()
				.initTerritory(5, 3);

		assertTerritory("     ;"
				      + "     ;"
				      + "     ;");
	}

	@Test
	public void givenEmptyTerritory3x2_whenAddOneGrainTo2x0_thenOneGrainIsPlacedOn2x0() {
		withTerritory("   ;" +
					  "   ;")
				.addGrainsToTile(locationOf(2, 0), amountOf(1));

		assertGrainsOnTerritory("  1;" +
				                "   ;");
	}

	@Test
	public void givenEmptyTerritory3x2_whenAddTwoGrainsTo1x1_thenTwoGrainsArePlacedOn1x1() {
		withTerritory("   ;" +
				      "   ;")
				.addGrainsToTile(locationOf(1, 1), amountOf(2));

		assertGrainsOnTerritory("   ;" +
				                " 2 ;");
	}

	@Test
	public void givenEmptyTerritory3x2_whenAddWallTo2x0_thenWallIsPlacedOn2x0() {
		withTerritory("   ;" +
					  "   ;")
				.addWallToTile(locationOf(2, 0));

		assertTerritory("  #;" +
				        "   ;");
	}

	@Test
	public void givenTerritory3x2_andHamsterOn0x0_andWallOn1x1_andGrainOn2x0_whenClearTile2x0_thenTile2x0IsEmpty() {
		withTerritory("v *;" +
					  " # ;")
				.clearTile(locationOf(2, 0));

		assertTerritory("v  ;" +
				        " # ;");
	}

	@Test
	public void givenTerritory3x2_andHamsterOn0x0_andWallOn1x1_andGrainOn2x0_whenClearTile1x1_thenTile1x1IsEmpty() {
		withTerritory("v *;" +
				      " # ;")
				.clearTile(locationOf(1, 1));

		assertTerritory("v *;" +
				        "   ;");
	}

	@Test
	public void givenTerritory1x1_andFiveGrainsOn0x0_whenClearTile0x0_thenTile0x0IsEmpty() {
		withTerritory(" ;")
				.addGrainsToTile(locationOf(0, 0), amountOf(5))
				.clearTile(locationOf(0, 0));

		assertTerritory(" ;");
	}

	@Test // Scenario: editor commands only in INITIALIZING
	public void givenTerritory1x1_andStartedGame_whenAddGrainsToTile_thenExceptionIsThrown() {
		withTerritory(" ;");
		startGame();
		assertThrows(IllegalStateException.class, () -> {
			sut.addGrainsToTile(locationOf(0, 0), amountOf(5));
		});
	}

	@Test // Scenario: init clears previous territory
	public void givenTerritory3x2_andHamsterOn0x0_andWallOn1x1_whenReinitTerritory1x1_andAddHamsterOn0x0_thenTerritoryIsRebuilt() {
		withTerritory("v *;" +
				      " # ;");
		sut.initTerritory(1, 1)
		   .initDefaultHamster(0, 0, Direction.NORTH, 1);
		assertTerritory("^;");
	}

	@Test // Scenario: hardReset allows editor commands again
	public void givenTerritory3x2_andHamsterOn1x1_whenStartGame_andHardReset_andReinitTerritory1x1_andAddHamsterOn0x0_thenTerritoryIsRebuilt() {
		withTerritory("   ;" +
				      " > ;");
		startGame();
		hardReset();
		sut.initTerritory(1, 1)
		   .initDefaultHamster(0, 0, Direction.NORTH, 1);
		assertTerritory("^;");
	}

	private void hardReset() {
		game.hardReset();
	}

	//<editor-fold desc="helpers">

	private TerritoryBuilder withTerritoryBuilder() {
		game = new HamsterGame();
		sut = new TerritoryBuilder(game);
		return sut;
	}

	/* used to create a already initialized territory */
	private TerritoryBuilder withTerritory(String map) {
		game = GameStringifier.createFromString(map);
		sut = new TerritoryBuilder(game);
		return sut;
	}

	private void startGame() {
		game.startGamePaused();
	}

	private void assertGrainsOnTerritory(String expected) {
		var actual = GameStringifier.grainsOnTerritoryToString(game);
		assertEquals(expected, actual.replace('0', ' '));
	}

	private void assertTerritory(String expected) {
		String actual = GameStringifier.toString(game);
		assertEquals(expected, actual);
	}

	private int amountOf(int amount) {
		return amount;
	}

	private Location locationOf(int column, int row) {
		var location = new Location();
		location.setColumn(column);
		location.setRow(row);
		return location;
	}

	//</editor-fold>

}
