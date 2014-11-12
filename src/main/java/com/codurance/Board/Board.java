package com.codurance.Board;

import com.codurance.Cell.Cell;
import com.codurance.Cell.CellReference;

import java.util.List;

public class Board {

    private final List<Cell> cells;
    private final BoardFormatter boardFormatter;

    public Board(List<Cell> cells, BoardFormatter boardFormatter) {
        this.cells = cells;
        this.boardFormatter = boardFormatter;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public String getBoardForPrinting() {
        return boardFormatter.format(cells);
    }

    public void addMove(CellReference cellReference, BoardMarker boardMarker) {
        cells.get(cellIndexValue(cellReference)).setValue(boardMarker.getValue());
    }

    private int cellIndexValue(CellReference cellReference) {
        return (Integer.parseInt(cellReference.getValue()) - 1);
    }
}
