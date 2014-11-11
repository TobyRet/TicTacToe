package com.codurance;

public class HumanPlayer implements Player {
    private final String name;
    private final String marker;

    public HumanPlayer(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }

    @Override
    public String getName() {
        return name;
    }
}
