package com.codurance.Game;

public class GameType {
    private String gameType;

    public GameType(String gameType) {
        this.gameType = gameType;
    }

    public boolean isSinglePlayer() {
        return gameType.equals("S");
    }

    public boolean isMultiPlayer() {
        return gameType.equals("M");
    }
}
