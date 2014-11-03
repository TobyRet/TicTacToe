package com.codurance;

import java.io.IOException;
import java.util.List;

public class MultiPlayerGame implements Game{

    private final List<Player> players;
    private final Board board;
    private final Console console;


    private Player currentPlayer;
    private int PLAYER_ONE = 0;
    private final int PLAYER_TWO = 1;

    public MultiPlayerGame(List<Player> players, Board board, Console console) {
        this.players = players;
        this.board = board;
        this.console = console;

        currentPlayer = players.get(0);
    }

    public void start() throws IOException {
        printBoard();
        requestNextMove(currentPlayer);
    }

    public void play(String cellReference) throws IOException {
        board.addMove(Integer.parseInt(cellReference) - 1, getCurrentPlayer());
        printBoard();
        changeCurrentPlayer();
        requestNextMove(currentPlayer);
    }

    private void changeCurrentPlayer() {
        currentPlayer = currentPlayer == players.get(PLAYER_ONE) ? players.get(PLAYER_TWO) : players.get(PLAYER_ONE);
    }

    private void requestNextMove(Player currentPlayer) throws IOException {
        play(console.requestNextMove(currentPlayer));
    }

    private void printBoard() {
        console.printBoard(board.getBoardForPrinting());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
