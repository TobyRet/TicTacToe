package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String SINGLEPLAYER_GAME = "S";
    private final String MULTIPLAYER_GAME = "M";
    private final Board board;
    private final List<Player> players;
    private final Console console;
    private List<Player> gamePlayers = new ArrayList();

    public Game(List<Player> players, Board board, Console console) {
        this.players = players;
        this.board = board;
        this.console = console;
    }

    public void start(GameType gameType) {
        checkIfMultiPLayerGameSelected(gameType);
        checkIfSinglePlayerGameSelected(gameType);
        printBoard();
        commenceGamePlay();
    }

    private void checkIfSinglePlayerGameSelected(GameType gameType) {
        if(gameType.getValue() == SINGLEPLAYER_GAME) {
            loadComputerAndHumanPlayers();
        }
    }

    private void checkIfMultiPLayerGameSelected(GameType gameType) {
        if(gameType.getValue() == MULTIPLAYER_GAME) {
            loadHumanPlayers();
        }
    }

    private void loadComputerAndHumanPlayers() {
        gamePlayers.add(players.get(0));
        gamePlayers.add(players.get(2));
    }

    private void loadHumanPlayers() {
        gamePlayers.add(players.get(0));
        gamePlayers.add(players.get(1));
    }

    private void commenceGamePlay() {
        for (Player player : gamePlayers) {
            player.makeMove();
        }
    }

    private void printBoard() {
        String boardForPrinting = board.getBoardForPrinting();
        console.printBoard(boardForPrinting);
    }

    public List<Player> getGamePlayers() {
        return gamePlayers;
    }
}
