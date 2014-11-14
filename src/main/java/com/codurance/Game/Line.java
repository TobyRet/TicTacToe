package com.codurance.Game;

import com.codurance.Cell.Cell;
import com.codurance.Cell.CellReference;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final int firstCellIndex;
    private final int secondCellIndex;
    private final int thirdCellIndex;
    private int move;

    public Line(int cell1, int cell2, int cell3) {
        this.firstCellIndex = cell1;
        this.secondCellIndex = cell2;
        this.thirdCellIndex = cell3;
    }

    public boolean cellsHaveSameValues(List<Cell> boardCells) {
        return firstCellIsNotNull(boardCells) && firstCellEqualsSecondCell(boardCells) && secondCellEqualsThirdCell(boardCells);
    }

    private boolean firstCellIsNotNull(List<Cell> boardCells) {
        return boardCells.get(firstCellIndex).value() != "-";
    }

    private boolean secondCellEqualsThirdCell(List<Cell> boardCells) {
        return boardCells.get(secondCellIndex).value() == boardCells.get(thirdCellIndex).value();
    }

    private boolean firstCellEqualsSecondCell(List<Cell> boardCells) {
        return boardCells.get(firstCellIndex).value() == boardCells.get(secondCellIndex).value();
    }

    public CellReference checkWinScenario(List<Cell> boardCells) {
        List<String> compareValues = new ArrayList<>();
        compareValues.add(boardCells.get(firstCellIndex).value());
        compareValues.add(boardCells.get(secondCellIndex).value());
        compareValues.add(boardCells.get(thirdCellIndex).value());

        if(compareValues.get(0) ==  compareValues.get(1)) {
            move = thirdCellIndex;
        }

        if(compareValues.get(0) ==  compareValues.get(2)) {
            move = secondCellIndex;
        }

        if(compareValues.get(1) ==  compareValues.get(2)) {
            move = firstCellIndex;
        }

        return new CellReference(String.valueOf(move));
    }
}
