package com.codurance.Board;

import com.codurance.Cell.Cell;
import com.codurance.Cell.Position;

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

    public void addMove(Position position, BoardMarker boardMarker) {
        cells.get(cellIndexValue(position)).setValue(boardMarker.getValue());
    }

    private int cellIndexValue(Position position) {
        return (Integer.parseInt(position.getValue()) - 1);
    }

    public boolean isEmpty() {
        return false;
    }
}
