package com.codurance.Players;

import com.codurance.Console;
import com.codurance.Game.Positions;
import com.codurance.Positions.Marker;

public class ComputerPlayer implements Player {

    @Override
    public void makeMove(Positions board, Console console) {
//        Position position = computerMove.calculateNextMove();
//        console.computerMoveConfirmation();
//        board.addMove(position, boardMarker);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Marker getMarker() {
        return null;
    }
}
