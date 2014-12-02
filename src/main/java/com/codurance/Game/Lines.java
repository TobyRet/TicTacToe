/*package com.codurance.Game;

import com.codurance.Cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Cell> boardCells;
    private List<Line> lines = new ArrayList();

    public Lines(List<Cell> boardCells, List<Line> lines) {
        this.boardCells = boardCells;
        this.lines = lines;
    }

    public boolean isThereAWinner() {
        boolean winstate = false;

        for(Line line : lines) {
            if(line.cellsHaveSameValues(boardCells)) {
                winstate = true;
            }
        }
        return winstate;
    }

    public Position determineWinPosition(List<Cell> boardCells) {
        List<Position> possiblePositions = new ArrayList();

        for(Line line : lines) {
            Position position = line.identifyWinScenarioCellPosition(boardCells);
            possiblePositions.add(position);
        }
        possiblePositions.removeAll(Collections.singleton(null));

        return possiblePositions.isEmpty() ? null : possiblePositions.get(0);
    }
}*/
