package com.codurance;

import com.codurance.Board.Board;
import com.codurance.Board.BoardFormatter;
import com.codurance.Board.BoardMarker;
import com.codurance.Cell.Cell;
import com.codurance.Game.Game;
import com.codurance.Game.Lines;
import com.codurance.Game.TicTacToe;
import com.codurance.Players.*;

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
    private static Lines lines;
    private static List<Cell> cells;
    private static List<Player> players;
    private static PlayerName playerNameHuman1;
    private static BoardMarker boardMarkerHuman1;
    private static HumanPlayer humanPlayer1;
    private static PlayerName playerNameHuman2;
    private static BoardMarker boardMarkerHuman2;
    private static HumanPlayer humanPlayer2;
    private static BoardMarker boardMarkerComputer;
    private static ComputerPlayer computerPlayer;
    private static ComputerPlayerStrategies computerPlayerStrategies;

    public static void main(String[] args) {
        createCells();
        createPlayers();
        scanner = new Scanner(System.in);
        console = new Console(scanner);
        boardFormatter = new BoardFormatter();
        board = new Board(cells, boardFormatter);
        lines = new Lines(board.getCells());
        game = new Game(players, board, console, lines);
        ticTacToe = new TicTacToe(console, game);

        ticTacToe.loadGameType();
    }

    private static void createPlayers() {
        players = new ArrayList();

        playerNameHuman1 = new PlayerName("Player 1");
        boardMarkerHuman1 = new BoardMarker("O");
        humanPlayer1 = new HumanPlayer(playerNameHuman1, boardMarkerHuman1);

        playerNameHuman2 = new PlayerName("Player 2");
        boardMarkerHuman2 = new BoardMarker("X");
        humanPlayer2 = new HumanPlayer(playerNameHuman2, boardMarkerHuman2);

        boardMarkerComputer = new BoardMarker("X");
        computerPlayerStrategies = new ComputerPlayerStrategies();
        computerPlayer = new ComputerPlayer(computerPlayerStrategies, boardMarkerComputer);

        players.add(humanPlayer1);
        players.add(humanPlayer2);
        players.add(computerPlayer);
    }

    private static void createCells() {
        cells = new ArrayList();
        for(int i=0; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
    }
}
