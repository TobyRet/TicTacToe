package com.codurance.Game;

import com.codurance.Board.Board;
import com.codurance.Console.Console;
import com.codurance.Players.BoardMarker;
import com.codurance.Players.HumanPlayer;
import com.codurance.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static final int PLAYER_ONE = 0;
	private static final int PLAYER_TWO = 1;
	private final Console console;
	private final Board board;
	private final List<Player> players = new ArrayList<>();
	private Player currentPlayer;

	public Game(Console console, Board board) {
		this.console = console;
		this.board = board;
	}

	public void start() {
		console.print("Welcome to Tic Tac Toe");
		loadPlayers();
		setCurrentPlayer(players.get(PLAYER_ONE));
		play();
	}

	private void loadPlayers() {
		players.add(new HumanPlayer(BoardMarker.NOUGHT, console));
		players.add(new HumanPlayer(BoardMarker.CROSS, console));
	}

	private void play() {
        requestMove();
		continueGamePlay();
		announceWinner();
        announceDraw();
	}

    private void requestMove() {
        console.print("Please submit your move");
        board.addMove(currentPlayer.boardMarker(),console.read());
        console.print(board.getBoardForPrinting());
    }

    private void continueGamePlay() {
		while(!board.isThereAWinner() && !board.isThereADraw()) {
			switchCurrentPlayer();
            requestMove();
		}
	}

	private void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}

	private void switchCurrentPlayer() {
		currentPlayer = currentPlayer == players.get(PLAYER_ONE) ? players.get(PLAYER_TWO) : players.get(PLAYER_ONE);
	}

	private void announceWinner() {
        if(board.isThereAWinner() && !board.isThereADraw()) {
		    console.print(currentPlayer.boardMarker().value() + " wins");
        }
	}

    private void announceDraw() {
        if(!board.isThereAWinner() && board.isThereADraw()) {
            console.print("Draw!");
        }
    }
}
