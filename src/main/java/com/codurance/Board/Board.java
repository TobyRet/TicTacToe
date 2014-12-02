/*package com.codurance.Board;

import com.codurance.Cell.Cell;
import com.codurance.Positions.Position;

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
        return 1; //(Integer.parseInt(position.value()) - 1); // fix this
    }

    public boolean isEmpty() {
        return false;
    }
}*/
