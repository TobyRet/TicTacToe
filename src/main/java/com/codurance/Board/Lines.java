package com.codurance.Board;

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

    public Integer completeForWin(Positions positions, Marker marker) {
        List<Integer> winningPositions = new ArrayList<>();

        for(Line line : lines) {
            winningPositions.add(line.completeARow(positions.getAll(), marker));
        }

        return winningPositions.get(0);
    }
}
