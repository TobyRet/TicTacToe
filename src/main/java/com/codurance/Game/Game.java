package com.codurance.Game;

import com.codurance.Board.Board;
import com.codurance.Console.Console;
import com.codurance.Players.Player;

import java.util.List;

public class Game {

    private final Console console;
    private final Board board;
    private final Players players;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private List<Player> gamePlayers;

    public Game(Console console, Board board, Players players) {
        this.console = console;
        this.board = board;
        this.players = players;
    }

    public void start() {
        loadPlayers();
        assignRoles();
        setCurrentPlayer(playerOne);
        currentPlayer.addMoveTo(board);
        play();
        announceWinner();
    }

    private void announceWinner() {
        console.printLine(currentPlayer.getMarker() + " wins");
    }

    private void play() {
        while(!board.isThereAWinner()) {
            switchCurrentPlayer();
            currentPlayer.addMoveTo(board);
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;
    }

    private void loadPlayers() {
        console.printLine("Select game type");
        gamePlayers = players.load(console.readLine());
    }

    private void assignRoles() {
        playerOne = gamePlayers.get(0);
        playerTwo = gamePlayers.get(1);
    }

    private void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }
}
