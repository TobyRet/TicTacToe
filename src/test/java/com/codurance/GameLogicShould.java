package com.codurance;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameLogicShould {
    private List<Cell> cells;
    private BoardFormatter boardFormatter;
    private Board board;
    private GameLogic gameLogic;
    private Player player1;
    private Player player2;

    @Before
    public void initialise() {
        boardFormatter = new BoardFormatter();
        createCells();
        board = new Board(cells, boardFormatter);
        gameLogic = new GameLogic(board);
        player1 = new Player("player 1", "O");
        player2 = new Player("player 2", "X");
    }

    @Test public void
    know_when_a_winning_state_has_been_achieved() {
        winningGameByRow();

        assertThat(gameLogic.checkForWin(), is(true));

        resetGame();

        winningGameByColumn();

        assertThat(gameLogic.checkForWin(), is(true));

        resetGame();

        winningGameByDiagonal();

        assertThat(gameLogic.checkForWin(), is(true));
    }

    @Test public void
    know_when_a_winning_game_has_not_been_achieved() {
        noWinningGame();

        assertThat(gameLogic.checkForWin(), is(false));
    }

    private void resetGame() {
        createCells();
        createNewBoard();
    }

    private void createNewBoard() {
        board = new Board(cells, boardFormatter);
    }

    private void winningGameByRow() {
        board.addMove(0, player1);
        board.addMove(1, player1);
        board.addMove(2, player1);
        board.addMove(3, player2);
        board.addMove(5, player2);
        board.addMove(7, player2);
    }

    private void noWinningGame() {
        board.addMove(0, player1);
        board.addMove(1, player1);
        board.addMove(5, player2);
        board.addMove(7, player2);
    }

    private void winningGameByDiagonal() {
        board.addMove(2, player1);
        board.addMove(3, player1);
        board.addMove(6, player1);
        board.addMove(0, player2);
        board.addMove(4, player2);
        board.addMove(7, player2);
    }

    private void winningGameByColumn() {
        board.addMove(0, player1);
        board.addMove(3, player1);
        board.addMove(6, player1);
        board.addMove(2, player2);
        board.addMove(4, player2);
        board.addMove(8, player2);
    }

    private List<Cell> createCells() {
        cells = new ArrayList();
        for(int i=0; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
        return cells;
    }
}
