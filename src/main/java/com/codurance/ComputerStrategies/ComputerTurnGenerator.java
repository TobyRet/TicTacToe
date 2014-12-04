package com.codurance.ComputerStrategies;

import com.codurance.Board.Marker;
import com.codurance.Board.Positions;

import java.util.List;

public class ComputerTurnGenerator {

    private final List<ComputerPlayerStrategy> computerPlayerStrategyList;

    public ComputerTurnGenerator(List<ComputerPlayerStrategy> computerPlayerStrategyList) {
        this.computerPlayerStrategyList = computerPlayerStrategyList;
    }

    public void calculateNextMove(Marker marker, Positions positions) {
        for(ComputerPlayerStrategy computerPlayerStrategy : computerPlayerStrategyList) {
            computerPlayerStrategy.execute(marker, positions);
        }
    }
}
