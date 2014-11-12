package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Cell.CellReference;
import com.codurance.Console;

public class ComputerPlayer implements Player {

    private final Board board;
    private final Console console;
    private final String playerName;
    private final ComputerPlayerStrategies computerPlayerStrategies;

    public ComputerPlayer(Board board, Console console, ComputerPlayerStrategies computerPlayerStrategies) {
        this.board = board;
        this.console = console;
        this.computerPlayerStrategies = computerPlayerStrategies;
        this.playerName = "Computer";
    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public void makeMove() {
        CellReference cellReference = computerPlayerStrategies.requestNextMove();
        board.addMove(cellReference);
    }
}
