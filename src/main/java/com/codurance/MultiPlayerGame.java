package com.codurance;

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

    public void start() {
        printBoard();
        printInstruction(currentPlayer);
    }

    public void play(int cellReference) {
        board.addMove(cellReference, getCurrentPlayer());
        printBoard();
        changeCurrentPlayer();

    }

    private void changeCurrentPlayer() {
        currentPlayer = currentPlayer == players.get(PLAYER_ONE) ? players.get(PLAYER_TWO) : players.get(PLAYER_ONE);
    }

    private void printInstruction(Player currentPlayer) {
        console.printPlayerInstruction(currentPlayer);
    }

    private void printBoard() {
        console.printBoard(board.getBoardForPrinting());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
