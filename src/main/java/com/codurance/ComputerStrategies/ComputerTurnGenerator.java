package com.codurance.ComputerStrategies;

import com.codurance.Board.Board;
import com.codurance.Players.BoardMarker;

import java.util.List;

public class ComputerTurnGenerator {

    private final List<ComputerPlayerStrategy> computerPlayerStrategyList;
    private ComputerPlayerStrategy winStrategy;
    private ComputerPlayerStrategy randomStrategy;

    public ComputerTurnGenerator(List<ComputerPlayerStrategy> computerPlayerStrategyList) {
        this.computerPlayerStrategyList = computerPlayerStrategyList;
    }

    public void calculateNextMove(BoardMarker marker, Board board) {
        winStrategy = computerPlayerStrategyList.get(0);
        randomStrategy = computerPlayerStrategyList.get(1);

        if(winStrategy.isFeasible(marker, board)) {
            winStrategy.execute(marker, board);
        } else {
            randomStrategy.execute(marker, board);
        }
    }
}
