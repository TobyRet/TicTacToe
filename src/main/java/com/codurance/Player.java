package com.codurance;

public class Player {
    private final String name;
    private final String marker;

    public Player(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }

    public String getName() {
        return name;
    }
}
