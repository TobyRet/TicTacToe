package com.codurance.Game;

import com.codurance.Board.Board;
import com.codurance.Console;
import com.codurance.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String SINGLEPLAYER_GAME = "S";
    private final String MULTIPLAYER_GAME = "M";
    private final Board board;
    private final List<Player> players;
    private final Console console;
    private final Lines lines;
    private List<Player> gamePlayers = new ArrayList();
    private Player currentPlayer;

    public Game(List<Player> players, Board board, Console console, Lines lines) {
        this.players = players;
        this.board = board;
        this.console = console;
        this.lines = lines;
    }

    public void start(GameType gameType) {
        checkIfMultiPlayerGameSelected(gameType);
        checkIfSinglePlayerGameSelected(gameType);
        printBoard();
        currentPlayer = gamePlayers.get(0);
        commenceGamePlay();
    }

    private void checkIfSinglePlayerGameSelected(GameType gameType) {
        if(gameType.getValue() == SINGLEPLAYER_GAME) {
            loadComputerAndHumanPlayers();
        }
    }

    private void checkIfMultiPlayerGameSelected(GameType gameType) {
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
        while(lines.checkForWin()==false) {
            currentPlayer.makeMove(board, console);
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == gamePlayers.get(0) ? gamePlayers.get(1) : gamePlayers.get(0);
    }

    private void printBoard() {
        String boardForPrinting = board.getBoardForPrinting();
        console.printBoard(boardForPrinting);
    }

    public List<Player> getGamePlayers() {
        return gamePlayers;
    }
}
