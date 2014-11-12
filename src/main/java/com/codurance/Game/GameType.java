package com.codurance.Game;

public class GameType {
    private final String userSelection;

    public GameType(String userSelection) {
        this.userSelection = userSelection;
    }

    public String getValue() {
        return userSelection;
    }
}
