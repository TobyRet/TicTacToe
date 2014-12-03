package com.codurance.Board;

import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean checkLinesForWinner(Positions positions) {
        boolean winner = false;

        for(Line line : lines) {
            if(line.doYouHaveWinner(positions)) {
                winner = true;
            }
        }

        return winner;
    }

//    public Position determineWinPosition(List<Cell> boardCells) {
//        List<Position> possiblePositions = new ArrayList();
//
//        for(Line line : lines) {
//            Position position = line.identifyWinScenarioCellPosition(boardCells);
//            possiblePositions.add(position);
//        }
//        possiblePositions.removeAll(Collections.singleton(null));
//
//        return possiblePositions.isEmpty() ? null : possiblePositions.get(0);
//    }
}
