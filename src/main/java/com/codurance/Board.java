package com.codurance;

import java.util.List;

public class Board {
    public List<Cell> getCells() {
        return cells;
    }

    private final List<Cell> cells;
    private final BoardFormatter boardFormatter;

    public Board(List<Cell> cells, BoardFormatter boardFormatter) {
        this.cells = cells;
        this.boardFormatter = boardFormatter;
    }

    public String getBoardForPrinting() {
        return boardFormatter.format(cells);
    }

    public void addMove(int cellReference, HumanPlayer currentPlayer) {
        if(cells.get(cellReference).getValue().equals("-")) {
            cells.get(cellReference).setValue(currentPlayer.getMarker());
            getBoardForPrinting();
        } else {
            throw new RuntimeException("Move has already been allocated for this cell");
        }
    }
}
