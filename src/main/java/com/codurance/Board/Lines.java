package com.codurance.Board;

import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean checkForWin(Board board) {
//        boolean winner = false;
//
//        for(Line line : lines) {
//            if(line.doYouHaveWinner(positions)) {
//                winner = true;
//            }
//        }
        return false;
    }

//    public Integer completeForWin(Board board, BoardMarker marker) {
//        List<Integer> winningPositions = new ArrayList<>();
//
//        for(Line line : lines) {
//            winningPositions.add(line.completeARow(board.getAll(), marker));
//        }
//
//        return winningPositions.get(0);
//    }

//    public boolean checkForWin(Board board) {
//        return false;
//    }
}
