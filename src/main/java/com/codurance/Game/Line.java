package com.codurance.Game;

import com.codurance.Cell.Cell;

import java.util.List;

public class Line {
    private final int firstCellIndex;
    private final int secondCellIndex;
    private final int thirdCellIndex;

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
}
