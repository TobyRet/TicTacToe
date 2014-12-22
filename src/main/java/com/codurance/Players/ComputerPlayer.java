package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.ComputerStrategies.ComputerTurnGenerator;
import com.codurance.Console.Console;

public class ComputerPlayer implements Player {

    private final ComputerTurnGenerator computerTurnGenerator;
    private final BoardMarker boardMarker;

    public ComputerPlayer(ComputerTurnGenerator computerTurnGenerator, BoardMarker boardMarker) {
        this.computerTurnGenerator = computerTurnGenerator;
        this.boardMarker = boardMarker;
    }

    @Override
    public void makeMove(Board board, Console console) {
        computerTurnGenerator.calculateNextMove(boardMarker, board);
        console.computerMoveConfirmation();
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public String getMarker() {
        return boardMarker.getMarker();
    }

}
