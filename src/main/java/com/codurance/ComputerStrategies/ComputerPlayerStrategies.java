package com.codurance.ComputerStrategies;

import com.codurance.Board.Board;
import com.codurance.Cell.Position;

public class ComputerPlayerStrategies {
    private final RandomStrategy randomStrategy;
    private Board board;

    public ComputerPlayerStrategies(RandomStrategy randomStrategy, Board board) {
        this.randomStrategy = randomStrategy;
        this.board = board;
    }

    public Position requestNextMove() {
        return randomStrategy.execute(board.getCells());
    }
}
