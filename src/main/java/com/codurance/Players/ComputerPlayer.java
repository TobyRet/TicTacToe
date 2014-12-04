package com.codurance.Players;

import com.codurance.Board.Marker;
import com.codurance.Board.Positions;
import com.codurance.ComputerStrategies.ComputerTurnGenerator;
import com.codurance.Console.Console;

public class ComputerPlayer implements Player {

    private final ComputerTurnGenerator computerTurnGenerator;
    private Marker marker;

    public ComputerPlayer(ComputerTurnGenerator computerTurnGenerator, Marker marker) {
        this.computerTurnGenerator = computerTurnGenerator;
        this.marker = marker;
    }

    @Override
    public void makeMove(Positions positions, Console console) {
        computerTurnGenerator.calculateNextMove(marker, positions);
        console.computerMoveConfirmation();
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
