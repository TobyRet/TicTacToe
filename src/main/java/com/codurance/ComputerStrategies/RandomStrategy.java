package com.codurance.ComputerStrategies;


import com.codurance.Cell.CellReference;
import com.codurance.Game.Lines;

public class RandomStrategy {
    private final Lines lines;

    public RandomStrategy(Lines lines) {
        this.lines = lines;
    }

    public CellReference execute() {
        return lines.getFirstAvailableMove();
    }
}
