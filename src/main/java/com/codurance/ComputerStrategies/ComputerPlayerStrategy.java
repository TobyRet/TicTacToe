package com.codurance.ComputerStrategies;

import com.codurance.Cell.Cell;
import com.codurance.Cell.Position;

import java.util.List;

public interface ComputerPlayerStrategy {

    Position execute(List<Cell> boardCells);
}
