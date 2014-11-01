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

@RunWith(MockitoJUnitRunner.class)
public class BoardShould {

    private List<Cell> cells;
    private Board board;
    @Mock BoardFormatter boardFormatter;

    @Before
    public void
    intialise_with_nine_cell_objects() {
        board = new Board(createCells());
    }

    @Test public void
    creates_an_empty_board_for_printing() {
        String emptyBoard = "---\n" + "---\n" + "---\n";
        given(boardFormatter.format(cells)).willReturn(emptyBoard);
        assertThat(board.getBoardForPrinting(), is(emptyBoard));
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
