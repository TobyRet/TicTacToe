package com.codurance.Positions;

public class Position {

    private final int boardPosition;

    public Position(int boardPosition) {
        this.boardPosition = boardPosition;

    }

    public int value() {
        return boardPosition;
    }
}
