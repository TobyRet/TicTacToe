package com.codurance.Board;

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
}
