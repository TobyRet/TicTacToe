package com.codurance.Board;

import com.codurance.Console.Formatter;
import com.codurance.Console.Console;
import com.codurance.Players.BoardMarker;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final String EMPTY_VALUE = "-";
    private final Lines lines;
    private List<String> positions = new ArrayList<>(9);
    private Formatter formatter;

    public Board(Formatter formatter, Lines lines) {
        this.formatter = formatter;
        this.lines = lines;
        createPositions();
    }

    public boolean areEmpty() {
        return positions.contains(EMPTY_VALUE);
    }

    public void addMove(BoardMarker marker, Position position) {
        positions.set(position.value(), marker.getMarker());
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
