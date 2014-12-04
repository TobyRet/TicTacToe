package com.codurance.ComputerStrategies;

import com.codurance.Board.Lines;
import com.codurance.Board.Marker;
import com.codurance.Board.Position;
import com.codurance.Board.Positions;

public class WinStrategy implements ComputerPlayerStrategy {

    private final Lines lines;

    public WinStrategy(Lines lines) {
        this.lines = lines;
    }

    @Override
    public void execute(Marker marker, Positions positions) {
        Integer positionIndex = getWinningPosition(marker, positions);
        positions.addMove(marker, new Position(positionIndex));
    }

    private Integer getWinningPosition(Marker marker, Positions positions) {
        return lines.completeForWin(positions, marker);
    }

    @Override
    public boolean isFeasible(Marker marker, Positions positions) {
        return lines.completeForWin(positions, marker) != null;
    }
}
