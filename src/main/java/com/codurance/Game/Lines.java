package com.codurance.Game;

import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean checkIfLineHasWinner() {
        boolean winner = false;

        for(Line line : lines) {
            if(line.doYouHaveWinner()) {
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
