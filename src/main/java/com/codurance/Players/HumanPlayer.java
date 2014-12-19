package com.codurance.Players;

import com.codurance.Console.Console;
import com.codurance.Board.Positions;
import com.codurance.Board.Marker;
import com.codurance.Board.Position;

public class HumanPlayer implements Player {

    private String name;
    private final Marker marker;

    public HumanPlayer(Marker marker) {
        this.marker = marker;
    }

    @Override
    public void makeMove(Positions positions, Console console) {
        Position position = console.requestNextMove(this);
        positions.addMove(marker, position);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Marker getMarker() {
        return marker;
    }
}
