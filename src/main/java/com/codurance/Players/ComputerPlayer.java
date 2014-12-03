package com.codurance.Players;

import com.codurance.Board.Marker;
import com.codurance.Board.Position;
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
        Position position = computerTurnGenerator.calculateNextMove(positions);
        console.computerMoveConfirmation();
        positions.addMove(marker, position);
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
