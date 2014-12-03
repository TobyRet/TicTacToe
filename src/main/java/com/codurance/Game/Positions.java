package com.codurance.Game;

import com.codurance.Board.Formatter;
import com.codurance.Console;
import com.codurance.Positions.Marker;
import com.codurance.Positions.Position;

import java.util.ArrayList;
import java.util.List;

public class Positions {

    private static final String EMPTY_VALUE = "-";
    private List<String> positions = new ArrayList<>(9);
    private Formatter formatter;

    public Positions(Formatter formatter) {
        this.formatter = formatter;
        createPositions();
    }

    public boolean areEmpty() {
        return positions.contains(EMPTY_VALUE);
    }

    public void addMove(Marker marker, Position position) {
        positions.set(position.value(), marker.value());
    }

    private void createPositions() {
        for(int i=0; i < 9; i++) {
            positions.add(EMPTY_VALUE);
        }
    }

    public void print(Console console) {
        formatter.print(console, positions);
    }
}
