package com.codurance.Board;

import com.codurance.Cell.Cell;

import java.util.List;

public class BoardFormatter {
    public String format(List<Cell> cells) {
        String formattedBoard = "\n" +
                cells.get(0).value() + " " + cells.get(1).value() + " " + cells.get(2).value() + "\n" +
                cells.get(3).value() + " " + cells.get(4).value() + " " + cells.get(5).value() + "\n" +
                cells.get(6).value() + " " + cells.get(7).value() + " " + cells.get(8).value() + "\n";
        return formattedBoard;
    }
}
