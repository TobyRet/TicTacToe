package com.codurance;

import java.io.IOException;
import java.util.List;

public class TwoPlayerGame {

    private final List<Player> players;
    private final Board board;
    private final Console console;
    private final GameLogic gameLogic;

    private Player currentPlayer;
    private int PLAYER_ONE = 0;
    private final int PLAYER_TWO = 1;
    private boolean winner = false;

    // too many arguments?
    public TwoPlayerGame(List<Player> players, Board board, Console console, GameLogic gameLogic) {
        this.players = players;
        this.board = board;
        this.console = console;
        this.gameLogic = gameLogic;

        currentPlayer = players.get(0);
    }

    public void start() throws IOException {
        printBoard();
        commenceGamePlay();
    }

    private void commenceGamePlay() throws IOException {
        for(int i=0; i<9; i++) {
            if (!winner) {
                runGame();
            }
        }
        if (!winner) {
            announceDraw();
        }
    }

    private void announceDraw() {
    }

    private void runGame() throws IOException {
        try {
            playTurn(requestNextMove(currentPlayer));
        } catch (RuntimeException e) {
            console.printCellTaken();
            playTurn(requestNextMove(currentPlayer));
        }
        checkForWin();
        printBoard();
        changeCurrentPlayer();
    }

    private void checkForWin() {
        if(gameLogic.checkForWin()) {
            winner = true;
            announceWinner();
        }
    }

    private void announceWinner() {
    }

    private int requestNextMove(Player currentPlayer) throws IOException {
        return Integer.parseInt(console.requestNextMove(currentPlayer)) - 1;
    }

    public void playTurn(int cellReference) throws IOException {
        board.addMove(cellReference, getCurrentPlayer());
    }

    private void printBoard() {
    }

    private void changeCurrentPlayer() {
        currentPlayer = currentPlayer == players.get(PLAYER_ONE) ? players.get(PLAYER_TWO) : players.get(PLAYER_ONE);
    }

    public Player getCurrentPlayer() {
        console.printDraw();
        console.printWinner(currentPlayer);
        console.printBoard(board.getBoardForPrinting());
        return currentPlayer;
    }

}
