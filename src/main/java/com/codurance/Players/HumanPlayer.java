package com.codurance.Players;

import com.codurance.Console;
import com.codurance.Game.Positions;
import com.codurance.Positions.Marker;
import com.codurance.Positions.Position;

public class HumanPlayer implements Player {

    private final PlayerName name;
    private final Marker marker;

    public HumanPlayer(PlayerName name, Marker marker) {
        this.name = name;
        this.marker = marker;
    }

    @Override
    public void makeMove(Positions positions, Console console) {
        Position position = console.requestNextMove(this);
        positions.addMove(marker, position);
    }

    @Override
    public String getName() {
        return name.getValue();
    }

    @Override
    public Marker getMarker() {
        return marker;
    }
}
