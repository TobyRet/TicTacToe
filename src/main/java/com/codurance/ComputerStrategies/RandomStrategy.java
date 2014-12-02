/*
package com.codurance.ComputerStrategies;


import com.codurance.Cell.Cell;
import com.codurance.Positions.Position;

import java.util.List;

public class RandomStrategy implements ComputerPlayerStrategy {

    private boolean notFoundEmptyPosition;

    @Override
    public Position execute(List<Cell> boardCells) {

        for(Cell cell : boardCells) {
            notFoundEmptyPosition = true;
            System.out.println("Current board values " + cell.value());
            if (notFoundEmptyPosition && cell.value().equals("-")) {
                String location = "" + (boardCells.indexOf(cell) + 1);
                notFoundEmptyPosition = false;
                return new Position(1); // fix the parametre here
            }
        }
        return null;
    }


}
*/
