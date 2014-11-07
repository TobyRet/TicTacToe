package com.codurance;

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

    @Test public void
    know_when_a_winning_state_has_been_achieved() {
        boardFormatter = new BoardFormatter();
        createCells();
        board = new Board(cells, boardFormatter);
        gameLogic = new GameLogic(board);
        player1 = new Player("player 1", "O");
        player2 = new Player("player 2", "X");

        board.addMove(0, player1);
        board.addMove(1, player1);
        board.addMove(2, player1);

        assertThat(gameLogic.checkForWin(), is(true));
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
