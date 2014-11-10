package com.codurance;

import java.io.IOException;

public class TicTacToe {
    private final Console console;
    private final MultiPlayerGame multiPlayerGame;

    public TicTacToe(Console console, MultiPlayerGame multiPlayerGame) {
        this.console = console;
        this.multiPlayerGame = multiPlayerGame;
    }

    public void loadGameType() throws IOException {
        if (console.requestGameType().equals("M")) {
            multiPlayerGame.start();
        }
    }
}