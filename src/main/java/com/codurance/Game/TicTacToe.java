package com.codurance.Game;

import com.codurance.Console;
import com.codurance.Game.Game;
import com.codurance.Game.GameType;

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