package com.codurance.Board;

import com.codurance.Players.BoardMarker;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean checkLinesForWinner(List<String> positions) {
        boolean winner = false;

        for(Line line : lines) {
            if(line.doYouHaveWinner(positions)) {
                winner = true;
            }
        }
        return winner;
    }

    public Integer completeForWin(Board board, BoardMarker marker) {
        List<Integer> winningPositions = new ArrayList<>();

        for(Line line : lines) {
            winningPositions.add(line.completeARow(board.getAll(), marker));
        }

        return winningPositions.get(0);
    }
}
