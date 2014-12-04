package com.codurance.ComputerStrategies;

import com.codurance.Board.Lines;
import com.codurance.Board.Marker;
import com.codurance.Board.Position;
import com.codurance.Board.Positions;

public class WinStrategy implements ComputerPlayerStrategy {

    private final Lines lines;
    private Position position;

    public WinStrategy(Lines lines) {
        this.lines = lines;
    }

    @Override
    public void execute(Marker marker, Positions positions) {
        position = lines.completeForWin(positions);
        positions.addMove(marker, position);
    }
}
