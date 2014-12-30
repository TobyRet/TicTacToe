package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.ComputerStrategies.ComputerTurnGenerator;

public class ComputerPlayer implements Player {

    private final ComputerTurnGenerator computerTurnGenerator;
    private final BoardMarker boardMarker;

    public ComputerPlayer(ComputerTurnGenerator computerTurnGenerator, BoardMarker boardMarker) {
        this.computerTurnGenerator = computerTurnGenerator;
        this.boardMarker = boardMarker;
    }

    @Override
    public void addMoveTo(Board board) {
        computerTurnGenerator.calculateNextMove(boardMarker, board);
        //console.computerMoveConfirmation();
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public BoardMarker getMarker() {
        return boardMarker;
    }

}
