package com.codurance.Board;

import com.codurance.Console.Formatter;
import com.codurance.Console.Console;

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

    public void print(Console console) {
        formatter.print(console, positions);
    }

    public void checkForWinner() {
        // add this
    }

    private void createPositions() {
        for(int i=0; i < 9; i++) {
            positions.add(EMPTY_VALUE);
        }
    }

}
