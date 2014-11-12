package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Board.BoardMarker;
import com.codurance.Cell.CellReference;
import com.codurance.Console;

public class ComputerPlayer implements Player {

    private final String playerName;
    private final ComputerPlayerStrategies computerPlayerStrategies;
    private BoardMarker boardMarker;

    public ComputerPlayer(ComputerPlayerStrategies computerPlayerStrategies, BoardMarker boardMarker) {
        this.computerPlayerStrategies = computerPlayerStrategies;
        this.boardMarker = boardMarker;
        this.playerName = "Computer";
    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public void makeMove(Board board, Console console) {
        CellReference cellReference = computerPlayerStrategies.requestNextMove();
        board.addMove(cellReference, boardMarker);
    }
}
