package com.codurance.Players;

import com.codurance.Cell.CellReference;
import com.codurance.Game.Lines;

public class ComputerPlayerStrategies {

    private final Lines lines;

    public ComputerPlayerStrategies(Lines lines) {
        this.lines = lines;
    }

    public CellReference requestNextMove() {
        return lines.calculateMoveForComputer();
    }
}
