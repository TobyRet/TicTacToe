package com.codurance.Game;

import com.codurance.Board.Board;
import com.codurance.Cell.Cell;
import com.codurance.Cell.Position;
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
public class LinesShould {
    private Lines lines;
    private List<Cell> cells;
    @Mock Board board;
    @Mock Line line;
    @Mock
    Position position;


    @Test public void
    set_win_state_to_true_when_each_cell_in_a_row_is_a_cross() {
        given(board.getCells()).willReturn(rowWinCrosses());
        lines = new Lines(board.getCells());
        assertThat(lines.checkIfThereIsAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_row_is_a_nought() {
        given(board.getCells()).willReturn(rowWinNoughts());
        lines = new Lines(board.getCells());
        assertThat(lines.checkIfThereIsAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_column_is_a_cross() {
        given(board.getCells()).willReturn(columnWinCrosses());
        lines = new Lines(board.getCells());
        assertThat(lines.checkIfThereIsAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_column_is_a_nought() {
        given(board.getCells()).willReturn(columnWinNoughts());
        lines = new Lines(board.getCells());
        assertThat(lines.checkIfThereIsAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_diagonal_is_a_cross() {
        given(board.getCells()).willReturn(diagonalWinCrosses());
        lines = new Lines(board.getCells());
        assertThat(lines.checkIfThereIsAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_diagonal_is_a_nought() {
        given(board.getCells()).willReturn(diagonalWinNoughts());
        lines = new Lines(board.getCells());
        assertThat(lines.checkIfThereIsAWinner(), is(true));
    }

    @Test public void
    not_change_win_state_if_there_is_no_winning_combination() {
        given(board.getCells()).willReturn(noWin());
        lines = new Lines(board.getCells());
        assertThat(lines.checkIfThereIsAWinner(), is(false));
    }

    private List<Cell> diagonalWinNoughts() {
        cells = new ArrayList();

        for(int i=0; i<9; i++) {
            if(i == 0 || i == 4 || i == 8) {
                Cell cell = new Cell();
                cell.setValue("O");
                cells.add(cell);
            } else {
                Cell cell = new Cell();
                cells.add(cell);
            }
        }
        return cells;
    }

    private List<Cell> diagonalWinCrosses() {
        cells = new ArrayList();

        for(int i=0; i<9; i++) {
            if(i == 2 || i == 4 || i == 6) {
                Cell cell = new Cell();
                cell.setValue("X");
                cells.add(cell);
            } else {
                Cell cell = new Cell();
                cells.add(cell);
            }
        }
        return cells;
    }

    private List<Cell> columnWinNoughts() {
        cells = new ArrayList();

        for(int i=0; i<9; i++) {
            if(i == 0 || i == 3 || i == 6) {
                Cell cell = new Cell();
                cell.setValue("O");
                cells.add(cell);
            } else {
                Cell cell = new Cell();
                cells.add(cell);
            }
        }
        return cells;
    }

    private List<Cell> columnWinCrosses() {
        cells = new ArrayList();

        for(int i=0; i<9; i++) {
            if(i == 0 || i == 3 || i == 6) {
                Cell cell = new Cell();
                cell.setValue("X");
                cells.add(cell);
            } else {
                Cell cell = new Cell();
                cells.add(cell);
            }
        }
        return cells;
    }

    private List<Cell> rowWinNoughts() {
        cells = new ArrayList();

        for(int i=0; i<3; i++) {
            Cell cell = new Cell();
            cell.setValue("O");
            cells.add(cell);
        }
        for(int i=3; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
        return cells;
    }

    private List<Cell> noWin() {
        cells = new ArrayList();

        for(int i=0; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
        return cells;
    }

    private List<Cell> rowWinCrosses() {
        cells = new ArrayList();

        for(int i=0; i<3; i++) {
            Cell cell = new Cell();
            cell.setValue("X");
            cells.add(cell);
        }

        for(int i=3; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }

        return cells;
    }

}
