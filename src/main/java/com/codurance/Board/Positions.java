package com.codurance.Board;

import com.codurance.Console.Formatter;
import com.codurance.Console.Console;

import java.util.ArrayList;
import java.util.List;

public class Positions {

    private static final String EMPTY_VALUE = "-";
    private final Lines lines;
    private List<String> positions = new ArrayList<>(9);
    private Formatter formatter;

    public Positions(Formatter formatter, Lines lines) {
        this.formatter = formatter;
        this.lines = lines;
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

    public boolean checkForWinner() {
        return lines.checkLinesForWinner(positions);
    }

    private void createPositions() {
        for(int i=0; i < 9; i++) {
            positions.add(EMPTY_VALUE);
        }
    }

    public List<String> getAll() {
        return positions;
    }
}
