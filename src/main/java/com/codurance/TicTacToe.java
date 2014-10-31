package com.codurance;

public class TicTacToe {
    private final Console console;
    private final MultiPlayerGame multiPlayerGame;


    public TicTacToe(Console console, MultiPlayerGame multiPlayerGame) {
        this.console = console;
        this.multiPlayerGame = multiPlayerGame;
    }

    public void loadGameType() {
        if(console.requestGameType() == "M") {
            multiPlayerGame.start();
        };
    }
}
