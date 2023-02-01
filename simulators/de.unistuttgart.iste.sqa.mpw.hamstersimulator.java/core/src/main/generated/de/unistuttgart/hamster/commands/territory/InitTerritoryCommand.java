/*
 * This file is generated. Do not change it manually.
 */

package de.unistuttgart.hamster.commands.territory;

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
* Defines a new territory by creating a new, empty territory of the given size.<br/>
* <br/>
* <b>requires / ensures:</b> the territory tiles must not be empty<br/>
* <b>requires:</b> size must be > 0<br/>
* <b>ensures:</b> size of territory is set
* 
*/

public class InitTerritoryCommand extends CompositeCommandBase {
	private final ConcreteTerritory self;

	private final int columns;

	private final int rows;

	public InitTerritoryCommand(InitTerritoryCommandParameters parameters) {
		this.self = parameters.self;
		this.columns = parameters.columns;
		this.rows = parameters.rows;
	}

	@Override
	public void execute() {

		/*
		* size must be > 0
		*/

		if ((columns > 0 && rows > 0) == false) {
			throw new CommandConstraintException("Violation of Precondition: size must be > 0");
		}

		if (!internalMainUnit()) {
			throw new RuntimeException("Transformation was not successfully executed: initTerritory");
		}

		/*
		* size of territory is set
		*/

		if ((self.getStageSize().getColumnCount() == columns

				&& self.getStageSize().getRowCount() == rows) == false) {
			throw new CommandConstraintException("Violation of Postcondition: size of territory is set");
		}

		/*
		* the territory tiles must not be empty
		*/

		if ((self.getTiles().size() > 0) == false) {
			throw new CommandConstraintException("Violation of ClassInvariant: the territory tiles must not be empty");
		}

	}
	private boolean internalMainUnit() {

		// new variable firstInRow: Tile
		Tile firstInRow;

		boolean result;

		result = clearTerritory();

		if (!result) {
			return false;
		}

		result = setSize(columns, rows);

		if (!result) {
			return false;
		}

		OutParameter<Tile> createInitialTileFirstInRowOutParameterWrapper = new OutParameter<Tile>();

		result = createInitialTile(createInitialTileFirstInRowOutParameterWrapper);

		firstInRow = createInitialTileFirstInRowOutParameterWrapper.get();

		if (!result) {
			return false;
		}

		result = createFirstRow(columns, firstInRow);

		if (!result) {
			return false;
		}

		OutParameter<Tile> createFurtherRowsFirstInRowOutParameterWrapper = new OutParameter<Tile>(firstInRow);

		result = createFurtherRows(createFurtherRowsFirstInRowOutParameterWrapper, columns, rows);

		firstInRow = createFurtherRowsFirstInRowOutParameterWrapper.get();

		if (!result) {
			return false;
		}

		return true;

	}

	private boolean createFirstRowTile(OutParameter<Tile> nextOutParameterWrapper) {
		Tile next = nextOutParameterWrapper.get();

		// new variable x: EInt
		int x;

		// new instance: next_forOutParameter:Tile
		Tile next_forOutParameter = new Tile();

		// new instance: newLocation:Location
		Location newLocation = new Location();

		if (!self.getTiles().contains(next)) {
			return false;
		}

		// new variable from reference: next:Tile -> location -> o0:Location

		Location o0 = next.getLocation();
		if (o0 == null) {
			return false;
		}

		x = o0.getColumn();

		// set attribute condition newLocation.column := x+1
		newLocation.setColumn(x + 1);

		// create reference: CREATE next:Tile -> east -> next_forOutParameter:Tile
		executeSetProperty(next, "east", next.getEast(), next_forOutParameter);

		// create reference: CREATE next_forOutParameter:Tile -> location -> newLocation:Location
		executeSetProperty(next_forOutParameter, "location", next_forOutParameter.getLocation(), newLocation);

		// create reference: CREATE self:EditorTerritory -> tiles -> next_forOutParameter:Tile
		executeAddReference(self, "tiles", next_forOutParameter);

		nextOutParameterWrapper.set(next_forOutParameter);

		return true;

	}

	private boolean createInitialTile(OutParameter<Tile> firstInRowOutParameterWrapper) {

		// new instance: firstInRow_forOutParameter:Tile
		Tile firstInRow_forOutParameter = new Tile();

		// new instance: o0:Location
		Location o0 = new Location();

		// create reference: CREATE firstInRow_forOutParameter:Tile -> location -> o0:Location
		executeSetProperty(firstInRow_forOutParameter, "location", firstInRow_forOutParameter.getLocation(), o0);

		// create reference: CREATE self:EditorTerritory -> tiles -> firstInRow_forOutParameter:Tile
		executeAddReference(self, "tiles", firstInRow_forOutParameter);

		firstInRowOutParameterWrapper.set(firstInRow_forOutParameter);

		return true;

	}

	private boolean createFirstTileForNextRow(OutParameter<Tile> firstInRowOutParameterWrapper) {
		Tile firstInRow = firstInRowOutParameterWrapper.get();

		// new variable y: EInt
		int y;

		// new instance: firstInRow_forOutParameter:Tile
		Tile firstInRow_forOutParameter = new Tile();

		// new instance: newLocation:Location
		Location newLocation = new Location();

		if (!self.getTiles().contains(firstInRow)) {
			return false;
		}

		// new variable from reference: firstInRow:Tile -> location -> o0:Location

		Location o0 = firstInRow.getLocation();
		if (o0 == null) {
			return false;
		}

		y = o0.getRow();

		// assert condition: o0.column == 0
		if (o0.getColumn() != 0) {
			return false;
		}

		// set attribute condition newLocation.row := y+1
		newLocation.setRow(y + 1);

		// create reference: CREATE firstInRow_forOutParameter:Tile -> location -> newLocation:Location
		executeSetProperty(firstInRow_forOutParameter, "location", firstInRow_forOutParameter.getLocation(),
				newLocation);

		// create reference: CREATE firstInRow:Tile -> south -> firstInRow_forOutParameter:Tile
		executeSetProperty(firstInRow, "south", firstInRow.getSouth(), firstInRow_forOutParameter);

		// create reference: CREATE self:EditorTerritory -> tiles -> firstInRow_forOutParameter:Tile
		executeAddReference(self, "tiles", firstInRow_forOutParameter);

		firstInRowOutParameterWrapper.set(firstInRow_forOutParameter);

		return true;

	}

	private boolean createFurtherRowTile(OutParameter<Tile> nextOutParameterWrapper) {
		Tile next = nextOutParameterWrapper.get();

		// new variable x: EInt
		int x;

		// new variable y: EInt
		int y;

		// new instance: next_forOutParameter:Tile
		Tile next_forOutParameter = new Tile();

		// new instance: newLocation:Location
		Location newLocation = new Location();

		// new variable from reference: next:Tile -> north -> north:Tile

		Tile north = next.getNorth();
		if (north == null) {
			return false;
		}

		if (!self.getTiles().contains(next)) {
			return false;
		}

		// new variable from reference: north:Tile -> east -> northEast:Tile

		Tile northEast = north.getEast();
		if (northEast == null) {
			return false;
		}

		// new variable from reference: next:Tile -> location -> o0:Location

		Location o0 = next.getLocation();
		if (o0 == null) {
			return false;
		}

		y = o0.getRow();

		x = o0.getColumn();

		// set attribute condition newLocation.row := y
		newLocation.setRow(y);

		// set attribute condition newLocation.column := x+1
		newLocation.setColumn(x + 1);

		// create reference: CREATE northEast:Tile -> south -> next_forOutParameter:Tile
		executeSetProperty(northEast, "south", northEast.getSouth(), next_forOutParameter);

		// create reference: CREATE next:Tile -> east -> next_forOutParameter:Tile
		executeSetProperty(next, "east", next.getEast(), next_forOutParameter);

		// create reference: CREATE next_forOutParameter:Tile -> location -> newLocation:Location
		executeSetProperty(next_forOutParameter, "location", next_forOutParameter.getLocation(), newLocation);

		// create reference: CREATE self:EditorTerritory -> tiles -> next_forOutParameter:Tile
		executeAddReference(self, "tiles", next_forOutParameter);

		nextOutParameterWrapper.set(next_forOutParameter);

		return true;

	}

	private boolean createFirstRow(int columns, Tile next) {

		boolean result;
		for (int i = 0; i < (columns - 1); i++) {

			OutParameter<Tile> createFirstRowTileNextOutParameterWrapper = new OutParameter<Tile>(next);

			result = createFirstRowTile(createFirstRowTileNextOutParameterWrapper);

			next = createFirstRowTileNextOutParameterWrapper.get();

			if (!result) {
				return false;
			}
		}

		return true;

	}

	private boolean createFurtherRows(OutParameter<Tile> firstInRowOutParameterWrapper, int columns, int rows) {
		Tile firstInRow = firstInRowOutParameterWrapper.get();

		boolean result;
		for (int i = 0; i < (rows - 1); i++) {

			OutParameter<Tile> createFurtherRowFirstInRowOutParameterWrapper = new OutParameter<Tile>(firstInRow);

			result = createFurtherRow(createFurtherRowFirstInRowOutParameterWrapper, columns);

			firstInRow = createFurtherRowFirstInRowOutParameterWrapper.get();

			if (!result) {
				return false;
			}
		}
		firstInRowOutParameterWrapper.set(firstInRow);

		return true;

	}

	private boolean createFurtherRow(OutParameter<Tile> firstInRowOutParameterWrapper, int columns) {
		Tile firstInRow = firstInRowOutParameterWrapper.get();

		boolean result;

		OutParameter<Tile> createFirstTileForNextRowFirstInRowOutParameterWrapper = new OutParameter<Tile>(firstInRow);

		result = createFirstTileForNextRow(createFirstTileForNextRowFirstInRowOutParameterWrapper);

		firstInRow = createFirstTileForNextRowFirstInRowOutParameterWrapper.get();

		if (!result) {
			return false;
		}

		result = createFurtherRowTiles(columns, firstInRow);

		if (!result) {
			return false;
		}
		firstInRowOutParameterWrapper.set(firstInRow);

		return true;

	}

	private boolean createFurtherRowTiles(int columns, Tile next) {

		boolean result;
		for (int i = 0; i < (columns - 1); i++) {

			OutParameter<Tile> createFurtherRowTileNextOutParameterWrapper = new OutParameter<Tile>(next);

			result = createFurtherRowTile(createFurtherRowTileNextOutParameterWrapper);

			next = createFurtherRowTileNextOutParameterWrapper.get();

			if (!result) {
				return false;
			}
		}

		return true;

	}

	private boolean setSize(int columns, int rows) {

		// new instance: o0:Size
		Size o0 = new Size();

		// set attribute condition o0.columnCount := columns
		o0.setColumnCount(columns);

		// set attribute condition o0.rowCount := rows
		o0.setRowCount(rows);

		// create reference: CREATE self:EditorTerritory -> stageSize -> o0:Size
		executeSetProperty(self, "stageSize", self.getStageSize(), o0);

		return true;

	}

	private boolean clearTiles() {

		// clear references: self:EditorTerritory -> tiles -> o1:Tile
		while (self.getTiles().size() > 0) {
			executeRemoveReference(self, "tiles", self.getTiles().get(0));
		}

		// clear references: self:EditorTerritory -> tileContents -> o0:TileContent
		while (self.getTileContents().size() > 0) {
			executeRemoveReference(self, "tileContents", self.getTileContents().get(0));
		}

		return true;

	}

	private boolean clearTerritory() {

		boolean result;

		result = hamsterIsOnTile();

		if (result) {

			result = clearHamsterAndTiles();

		} else {

			result = clearTiles();

		}

		return result;

	}

	private boolean hamsterIsOnTile() {

		// new variable from reference: self:EditorTerritory -> defaultHamster -> o0:EditorHamster

		EditorHamster o0 = (self.getDefaultHamster() instanceof EditorHamster)
				? (EditorHamster) self.getDefaultHamster()
				: null;
		if (o0 == null) {
			return false;
		}

		// new variable from reference: o0:EditorHamster -> currentTile -> o1:Tile

		Tile o1 = o0.getCurrentTile();
		if (o1 == null) {
			return false;
		}

		return true;

	}

	private boolean clearHamsterAndTiles() {

		boolean result;

		result = resetHamsterTile();

		if (!result) {
			return false;
		}

		result = clearTiles();

		if (!result) {
			return false;
		}

		return true;

	}

	private boolean resetHamsterTile() {

		// new variable from reference: self:EditorTerritory -> defaultHamster -> o0:EditorHamster

		EditorHamster o0 = (self.getDefaultHamster() instanceof EditorHamster)
				? (EditorHamster) self.getDefaultHamster()
				: null;
		if (o0 == null) {
			return false;
		}

		// new variable from reference: o0:EditorHamster -> currentTile -> o1:Tile

		Tile o1 = o0.getCurrentTile();
		if (o1 == null) {
			return false;
		}

		// remove reference: DELETE o0:EditorHamster -> currentTile -> o1:Tile

		executeSetProperty(o0, "currentTile", o0.getCurrentTile(), null);

		return true;

	}

}
