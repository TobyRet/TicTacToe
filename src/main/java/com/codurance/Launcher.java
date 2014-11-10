package com.codurance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void main(String[] args) throws IOException {
        TicTacToe ticTacToe = loadTicTacToe();
        ticTacToe.loadGameType();
    }

    private static TicTacToe loadTicTacToe() {
        List<Player> players = initialisePlayers();
        List<Cell> cells = initialiseCells();
        BoardFormatter boardFormatter = new BoardFormatter();
        Board board = new Board(cells, boardFormatter);
        GameLogic gameLogic = new GameLogic(board);
        Console console = new Console();
        MultiPlayerGame multiPlayerGame = new MultiPlayerGame(players, board, console, gameLogic);
        return new TicTacToe(console, multiPlayerGame);
    }

    private static List<Player> initialisePlayers() {
        Player player1 = new Player("Player 1", "O");
        Player player2 = new Player("Player 2", "X");
        List<Player> players = new ArrayList();
        players.add(player1);
        players.add(player2);
        return players;
    }

    private static List<Cell> initialiseCells() {
        List<Cell> cells = new ArrayList();
        for(int i=0; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
        return cells;
    }
}
