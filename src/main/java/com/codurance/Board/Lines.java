package com.codurance.Board;

import java.util.List;
import java.util.stream.Collectors;

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

    public Position completeForWin(Positions positions) {
        List<Position> winningPositions = lines.stream().map(line -> line.completeARow(positions))
                                                                    .collect(Collectors.toList());

        return winningPositions.get(0);
    }
}
