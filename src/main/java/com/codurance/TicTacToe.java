package com.codurance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    private final Console console;

    public TicTacToe(Console console) {
        this.console = console;
    }

    public void loadGameType() throws IOException {
        if(console.requestGameType().equals("M")) {
            BoardFormatter boardFormatter = new BoardFormatter();

            List<Cell> cells = new ArrayList();
            for(int i=0; i<9; i++) {
                Cell cell = new Cell();
                cells.add(cell);
            }

            Player player1 = new Player("Player 1", "O");
            Player player2 = new Player("Player 2", "X");

            List<Player> players = new ArrayList();
            players.add(player1);
            players.add(player2);

            Board board = new Board(cells, boardFormatter);

            MultiPlayerGame multiPlayerGame = new MultiPlayerGame(players, board, console);
            multiPlayerGame.start();
        };
    }
}
