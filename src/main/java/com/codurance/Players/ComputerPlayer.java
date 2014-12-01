package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Board.BoardMarker;
import com.codurance.Cell.Position;
import com.codurance.ComputerStrategies.ComputerMove;
import com.codurance.Console;

public class ComputerPlayer implements Player {

    private final String playerName;
    private final ComputerMove computerMove;
    private BoardMarker boardMarker;

    public ComputerPlayer(ComputerMove computerMove, BoardMarker boardMarker) {
        this.computerMove = computerMove;
        this.boardMarker = boardMarker;
        this.playerName = "Computer";
    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public void makeMove(Board board, Console console) {
        Position position = computerMove.calculateNextMove();
        console.computerMoveConfirmation();
        board.addMove(position, boardMarker);
    }
}
