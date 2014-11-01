package com.codurance;

import java.util.List;

public class Board {
    private final List<Cell> cells;
    private String boardForPrinting;

    public Board(List<Cell> cells) {
        this.cells = cells;
    }

    public String getBoardForPrinting() {
        return boardForPrinting;
    }

    public void addMove(int cellReference, Player currentPlayer) {
    }
}
