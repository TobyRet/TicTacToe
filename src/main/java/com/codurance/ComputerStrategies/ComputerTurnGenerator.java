package com.codurance.ComputerStrategies;

import com.codurance.Board.Marker;
import com.codurance.Board.Positions;

import java.util.List;

public class ComputerTurnGenerator {

    private final List<ComputerPlayerStrategy> computerPlayerStrategyList;
    private ComputerPlayerStrategy winStrategy;
    private ComputerPlayerStrategy randomStrategy;

    public ComputerTurnGenerator(List<ComputerPlayerStrategy> computerPlayerStrategyList) {
        this.computerPlayerStrategyList = computerPlayerStrategyList;
    }

    public void calculateNextMove(Marker marker, Positions positions) {
        winStrategy = computerPlayerStrategyList.get(0);
        randomStrategy = computerPlayerStrategyList.get(1);

        if(winStrategy.isFeasible(marker, positions)) {
            winStrategy.execute(marker, positions);
        } else {
            randomStrategy.execute(marker, positions);
        }
    }
}
