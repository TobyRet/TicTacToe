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
        commenceGamePlay();
    }

    private void commenceGamePlay() throws IOException {
        for(int i=0; i < 9; i++) {
            playTurn(requestNextMove(currentPlayer));
            printBoard();
            changeCurrentPlayer();
        }
    }

    private int requestNextMove(Player currentPlayer) throws IOException {
        return Integer.parseInt(console.requestNextMove(currentPlayer)) - 1;
    }

    public void playTurn(int cellReference) throws IOException {
        board.addMove(cellReference, getCurrentPlayer());
    }

    private void printBoard() {
        console.printBoard(board.getBoardForPrinting());
    }

    private void changeCurrentPlayer() {
        currentPlayer = currentPlayer == players.get(PLAYER_ONE) ? players.get(PLAYER_TWO) : players.get(PLAYER_ONE);
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
