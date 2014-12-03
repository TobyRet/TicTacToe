package com.codurance.Game;

import com.codurance.Console;
import com.codurance.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players;
    private final Console console;
    private final Lines lines;
    private List<Player> gamePlayers = new ArrayList();
    private Player currentPlayer;
    private Positions positions;

    public Game(List<Player> players, Positions positions, Console console, Lines lines) {
        this.players = players;
        this.positions = positions;
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
            currentPlayer.makeMove(positions, console);
            printBoard();
            switchPlayer();
        }
    }

    private boolean gameIncomplete() {
        return lines.checkIfLineHasWinner() == false && positions.areEmpty() == true;
    }

    private void checkForDraw() {
        if(thereIsADraw()) {
            console.printDraw();
        }
    }

    private boolean thereIsADraw() {
        return lines.checkIfLineHasWinner() == false && positions.areEmpty() == false;
    }

    private void announceWinner() {
        switchPlayer();
        console.printWinner(currentPlayer);
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == gamePlayers.get(0) ? gamePlayers.get(1) : gamePlayers.get(0);
    }

    private void printBoard() {
        positions.print(console);
    }

    public List<Player> getGamePlayers() {
        return gamePlayers;
    }
}
