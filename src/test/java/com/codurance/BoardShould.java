package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BoardShould {

    private List<Cell> cells;
    private Board board;
    @Mock BoardFormatter boardFormatter;
    @Mock Cell mockedCell;

    @Before
    public void
    intialise_with_nine_cell_objects() {
        board = new Board(createCells(), boardFormatter);
    }

    @Test public void
    creates_an_empty_board_for_printing() {
        String emptyBoard = "---\n" + "---\n" + "---\n";
        given(boardFormatter.format(cells)).willReturn(emptyBoard);
        assertThat(board.getBoardForPrinting(), is(emptyBoard));
    }

    @Test public void
    add_a_players_move_to_the_board() {
        Player player1 = new Player();
        board = new Board(createMockedCells(), boardFormatter);

        String boardWithOneMove = "X--\n" + "---\n" + "---\n";

        given(boardFormatter.format(cells)).willReturn(boardWithOneMove);

        board.addMove(1, player1);

        verify(mockedCell).setValue("X");

        assertThat(board.getBoardForPrinting(), is(boardWithOneMove));
    }

    private List<Cell> createMockedCells() {
        cells = new ArrayList();
        for(int i=0; i<9; i++) {
            cells.add(mockedCell);
        }
        return cells;
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
