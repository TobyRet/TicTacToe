package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String SINGLEPLAYER_GAME = "S";
    private final String MULTIPLAYER_GAME = "M";
    private final Board board;
    private final List<Player> players;
    private final GameLogic gameLogic;
    private final Console console;

    private Player currentPlayer;
    private int PLAYER_ONE = 0;
    private final int PLAYER_TWO = 1;
    private boolean winner = false;
    private List<Player> gamePlayers = new ArrayList();

    public Game(List<Player> players, GameLogic gameLogic, Board board, Console console) {
        this.players = players;
        this.gameLogic = gameLogic;
        this.board = board;
        this.console = console;

//        currentPlayer = players.get(0);
    }

    public void start(GameType gameType) {
        if(gameType.getValue() == MULTIPLAYER_GAME) {
            loadHumanPlayers();
        }
        if(gameType.getValue() == SINGLEPLAYER_GAME) {
            loadComputerAndHumanPlayers();
        }

        printBoard();
//        commenceGamePlay();
    }

    private void loadComputerAndHumanPlayers() {
        gamePlayers.add(players.get(0));
        gamePlayers.add(players.get(2));
    }

    private void loadHumanPlayers() {
        gamePlayers.add(players.get(0));
        gamePlayers.add(players.get(1));
    }

//    private void commenceGamePlay() {
//        for(int i=0; i<9; i++) {
//            if (!winner) {
//                playTurn(requestNextMove(currentPlayer));
//                checkForWin();
//                printBoard();
//                changeCurrentPlayer();
//            }
//        }
//    }
//
//    private void checkForWin() {
//        if(gameLogic.checkForWin()) {
//            winner = true;
//            announceWinner();
//        }
//    }
//
//    private void announceWinner() {
//        console.printWinner(currentPlayer);
//    }
//
//    private int requestNextMove(Player currentPlayer) {
//        return Integer.parseInt(console.requestNextMove(currentPlayer)) - 1;
//    }
//
//    public void playTurn(int cellReference) {
//        board.addMove(cellReference, getCurrentPlayer());
//    }

    private void printBoard() {
        String boardForPrinting = board.getBoardForPrinting();
        console.printBoard(boardForPrinting);
    }

//    private void changeCurrentPlayer() {
//        currentPlayer = currentPlayer == players.get(PLAYER_ONE) ? players.get(PLAYER_TWO) : players.get(PLAYER_ONE);
//    }
//
//    public Player getCurrentPlayer() {
//        return currentPlayer;
//    }

    public List<Player> getGamePlayers() {
        return gamePlayers;
    }
}
