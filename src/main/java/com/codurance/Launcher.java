package com.codurance;

import com.codurance.Board.Board;
import com.codurance.Board.BoardFormatter;
import com.codurance.Board.BoardMarker;
import com.codurance.Cell.Cell;
import com.codurance.Game.Game;
import com.codurance.Game.GameLogic;
import com.codurance.Game.TicTacToe;
import com.codurance.Game.WinningCombinations;
import com.codurance.Players.ComputerPlayer;
import com.codurance.Players.HumanPlayer;
import com.codurance.Players.Player;
import com.codurance.Players.PlayerName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    private static Console console;
    private static Game game;
    private static Scanner scanner;
    private static TicTacToe ticTacToe;
    private static BoardFormatter boardFormatter;
    private static Board board;
    private static GameLogic gameLogic;
    private static WinningCombinations winningCombinations;
    private static List<Cell> cells;
    private static List<Player> players;

    public static void main(String[] args) {
        createCells();
        createPlayers();
        console = new Console(scanner);
        boardFormatter = new BoardFormatter();
        board = new Board(cells, boardFormatter);
        winningCombinations = new WinningCombinations();
        gameLogic = new GameLogic(board, winningCombinations);
        game = new Game(players, board, console, gameLogic);
        scanner = new Scanner(System.in);
        ticTacToe = new TicTacToe(console, game);

        ticTacToe.loadGameType();
    }

    private static void createPlayers() {
        players = new ArrayList();

        PlayerName playerNameHuman1 = new PlayerName("Player 1");
        BoardMarker boardMarkerHuman1 = new BoardMarker("O");
        HumanPlayer humanPlayer1 = new HumanPlayer(playerNameHuman1, boardMarkerHuman1);

        PlayerName playerNameHuman2 = new PlayerName("Player 2");
        BoardMarker boardMarkerHuman2 = new BoardMarker("X");
        HumanPlayer humanPlayer2 = new HumanPlayer(playerNameHuman2, boardMarkerHuman2);

        BoardMarker boardMarkerComputer = new BoardMarker("X");
        ComputerPlayer computerPlayer = new ComputerPlayer()


    }

    private static void createCells() {
        cells = new ArrayList();
        for(int i=0; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
    }
}
