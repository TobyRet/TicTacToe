package com.codurance;

public class GameType {
    private final String userSelection;

    public GameType(String userSelection) {
        this.userSelection = userSelection;
    }

    public String getValue() {
        return userSelection;
    }
}
