package com.codurance.ComputerStrategies;

import com.codurance.Cell.CellReference;

public class ComputerPlayerStrategies {
    private final RandomStrategy randomStrategy;

    public ComputerPlayerStrategies(RandomStrategy randomStrategy) {
        this.randomStrategy = randomStrategy;
    }

    public CellReference requestNextMove() {
        return randomStrategy.execute();
    }
}
