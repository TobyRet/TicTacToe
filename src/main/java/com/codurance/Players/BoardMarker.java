package com.codurance.Players;

public enum BoardMarker {
    CROSS("X"), NOUGHT("O");

    private final String marker;

    BoardMarker(String marker) {
        this.marker = marker;
    }

    public String value() {
        return marker;
    }
}
