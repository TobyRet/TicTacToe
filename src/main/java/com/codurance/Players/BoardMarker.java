package com.codurance.Players;

public enum BoardMarker {
    CROSS("X"), NOUGHT("O");

    private String marker;

    BoardMarker(String marker) {
        this.marker = marker;
    }

    public String value() {
        return marker;
    }
}
