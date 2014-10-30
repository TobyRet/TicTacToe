package com.codurance;

import java.util.List;

public class Board {


    private final List<Cell> cells;

    public Board(List<Cell> cells) {
        this.cells = cells;
    }

    public String getState() {
        String state = "";
        for(Cell cell : cells) state += cell.getValue();
        return state;
    }
}
