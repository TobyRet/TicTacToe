package com.codurance;

import java.util.List;

public class SinglePlayerGame {

    private final List<Player> players;
    private final Board board;
    private final GameLogic gameLogic;
    private Console console;

    public SinglePlayerGame(List<Player> players, Board board, Console console, GameLogic gameLogic) {
        this.players = players;
        this.board = board;
        this.console = console;
        this.gameLogic = gameLogic;
    }

    public void start() {

    }

}
