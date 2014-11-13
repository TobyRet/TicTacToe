package com.codurance.Game;

import com.codurance.Cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Cell> boardCells;
    private List<Line> lines = new ArrayList();

    public Lines(List<Cell> boardCells) {
        this.boardCells = boardCells;
        createLines();
    }

    private void createLines() {
        Line row1 = new Line(0,1,2);
        Line row2 = new Line(3,4,5);
        Line row3 = new Line(6,7,8);
        Line column1 = new Line(0,3,6);
        Line column2 = new Line(1,4,7);
        Line column3 = new Line(2,5,8);
        Line diagonal1 = new Line(0,4,8);
        Line diagonal2 = new Line(2,4,6);

        lines.add(row1);
        lines.add(row2);
        lines.add(row3);
        lines.add(column1);
        lines.add(column2);
        lines.add(column3);
        lines.add(diagonal1);
        lines.add(diagonal2);
    }

    public boolean checkForWin() {
        boolean winstate = false;
        for(Line line : lines) {
            if(line.cellsHaveSameValues(boardCells)) {
                winstate = true;
            }
        }
        return winstate;
    }
}
