package com.codurance;

import java.util.List;

public class BoardFormatter {
    public String format(List<Cell> cells) {
        String formattedBoard = "\n" +
                cells.get(0).getValue() + " " + cells.get(1).getValue() + " " + cells.get(2).getValue() + "\n" +
                cells.get(3).getValue() + " " + cells.get(4).getValue() + " " + cells.get(5).getValue() + "\n" +
                cells.get(6).getValue() + " " + cells.get(7).getValue() + " " + cells.get(8).getValue() + "\n";
        return formattedBoard;
    }
}
