package com.codurance.Game;

import com.codurance.Console;

public class TicTacToe {
    private final Console console;
    private final Game game;

    public TicTacToe(Console console, Game game) {
        this.console = console;
        this.game = game;
    }

    public void loadGameType() {
        GameType gameType = console.requestGameType();
        game.start(gameType);
    }
}