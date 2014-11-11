package com.codurance;

import java.io.IOException;

public class TicTacToe {
    private final Console console;
    private final SinglePlayerGame singlePlayerGame;
    private final TwoPlayerGame twoPlayerGame;

    public TicTacToe(Console console, SinglePlayerGame singlePlayerGame, TwoPlayerGame twoPlayerGame) {
        this.console = console;
        this.singlePlayerGame = singlePlayerGame;
        this.twoPlayerGame = twoPlayerGame;
    }

    public void loadGame() throws IOException {
        String gameType = console.requestGameType();

        loadSinglePlayerGame(gameType);
        loadTwoPlayerGame(gameType);
        printInvalidSelectionError(gameType);

    }

    private void printInvalidSelectionError(String gameType) {
        if(gameType != "M" || gameType != "S") {
            console.printInvalidGameType();
        }
    }

    private void loadTwoPlayerGame(String gameType) throws IOException {
        if(gameType == "M") {
            twoPlayerGame.start();
        }
    }

    private void loadSinglePlayerGame(String gameType) {
        if(gameType == "S") {
            singlePlayerGame.start();
        }
    }
}