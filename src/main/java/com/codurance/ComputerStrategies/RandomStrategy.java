package com.codurance.ComputerStrategies;


import com.codurance.Cell.Cell;
import com.codurance.Cell.Position;

import java.util.List;

public class RandomStrategy {

    public Position execute(List<Cell> boardCells) {
        Position position = null;

        for(Cell cell : boardCells) {
            if (position == null && cell.value().equals("-")) {
                String location = "" + (boardCells.indexOf(cell) + 1);
                position = new Position(location);
            }
        }
        return position;
    }
}
