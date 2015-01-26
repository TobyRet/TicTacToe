package com.codurance.Board;

import java.util.List;

public class LinesChecker {

    private List<Line> lines;

    public LinesChecker(List<Line> lines) {
        this.lines = lines;
    }

    public boolean checkForWin(List<Move> board) {
        boolean winner = false;
        for(Line line : lines) {
            if(line.doYouHaveWinner(board)) {
                winner = true;
            }
        }
        return winner;
    }

//    public Integer completeForWin(Board board, BoardMarker marker) {
//        List<Integer> winningPositions = new ArrayList<>();
//
//        for(Line line : lines) {
//            winningPositions.add(line.completeARow(board.getAll(), marker));
//        }
//
//        return winningPositions.getBoard(0);
//    }

//    public boolean checkForWin(Board board) {
//        return false;
//    }
}
