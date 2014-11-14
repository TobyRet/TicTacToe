package com.codurance.Board;

import com.codurance.Cell.Cell;
import com.codurance.Cell.CellReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BoardShould {

    private static final String EMPTY_BOARD = "- - -\n" + "- - -\n" + "- - -\n";
    private List<Cell> cells;
    private Board board;
    private final String BOARD_WITH_ONE_MOVE = "\nX - -\n" + "- - -\n" + "- - -\n";

    @Mock BoardFormatter mockedBoardFormatter;
    @Mock CellReference cellReference;
    @Mock BoardMarker boardMarker;

    @Test public void
    creates_an_empty_board_for_printing() {
        board = new Board(createEmptyCells(), mockedBoardFormatter);

        given(mockedBoardFormatter.format(cells)).willReturn(EMPTY_BOARD);

        assertThat(board.getBoardForPrinting(), is(EMPTY_BOARD));
    }

    @Test public void
    add_a_players_move_to_the_board() {
        BoardFormatter boardFormatter = new BoardFormatter();
        board = new Board(createEmptyCells(), boardFormatter);
        
        given(boardMarker.getValue()).willReturn("X");
        given(cellReference.getValue()).willReturn("1");

        board.addMove(cellReference, boardMarker);

        assertThat(board.getBoardForPrinting(), is(BOARD_WITH_ONE_MOVE));
    }

    @Test public void
    know_if_has_empty_cells() {
        BoardFormatter boardFormatter = new BoardFormatter();
        board = new Board(createFullCells(), boardFormatter);
    }

    private List<Cell> createFullCells() {
        cells = new ArrayList();

        for(int i=0; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
        return cells;
    }

    private List<Cell> createEmptyCells() {
        cells = new ArrayList();

        for(int i=0; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
        return cells;
    }
}
