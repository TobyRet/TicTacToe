package com.codurance.ComputerStrategies;

import com.codurance.Cell.Cell;
import com.codurance.Cell.Position;
import com.codurance.Game.Lines;

import java.util.List;

public class WinStrategy implements ComputerPlayerStrategy {
    private final Lines lines;

    public WinStrategy(Lines lines) {
        this.lines = lines;
    }

    @Override
    public Position execute(List<Cell> boardCells) {
        return lines.determineWinPosition(boardCells);
    }
}
