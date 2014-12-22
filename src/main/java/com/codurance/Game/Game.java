package com.codurance.Game;

import com.codurance.Console.Console;
import com.codurance.Players.Player;
import com.codurance.Board.Lines;
import com.codurance.Board.Board;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players;
    private final Console console;
    private final Lines lines;
    private List<Player> gamePlayers = new ArrayList();
    private Player currentPlayer;
    private Board board;

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
        commenceGamePlay();
    }

    private void checkIfSinglePlayerGameSelected(GameType gameType) {
        if(gameType.isSinglePlayer()) {
            loadComputerAndHumanPlayers();
        }
    }

    private void checkIfMultiPlayerGameSelected(GameType gameType) {
        if(gameType.isMultiPlayer()) {
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
        currentPlayer = gamePlayers.get(0);

        makeMoves();
        checkForDraw();
        announceWinner();
    }

    private void makeMoves() {
        while(gameIncomplete()) {
            currentPlayer.makeMove(board, console);
            printBoard();
            switchPlayer();
        }
    }

    private boolean gameIncomplete() {
        return board.checkForWinner() == false && board.areEmpty() == true;
    }

    private void checkForDraw() {
        if(thereIsADraw()) {
            console.printDraw();
        }
    }

    private boolean thereIsADraw() {
        return board.checkForWinner() == false && board.areEmpty() == false;
    }

    private void announceWinner() {
        switchPlayer();
        console.printWinner(currentPlayer);
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == gamePlayers.get(0) ? gamePlayers.get(1) : gamePlayers.get(0);
    }

    private void printBoard() {
        board.print(console);
    }

    public List<Player> getGamePlayers() {
        return gamePlayers;
    }
}
