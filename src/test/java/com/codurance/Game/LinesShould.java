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
    @Mock Position mockedPosition;
    @Mock Line mockedLine;

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_row_is_a_cross() {
        given(board.getCells()).willReturn(rowWinCrosses());
        lines = new Lines(board.getCells(), createLines());
        assertThat(lines.isThereAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_row_is_a_nought() {
        given(board.getCells()).willReturn(rowWinNoughts());
        lines = new Lines(board.getCells(), createLines());
        assertThat(lines.isThereAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_column_is_a_cross() {
        given(board.getCells()).willReturn(columnWinCrosses());
        lines = new Lines(board.getCells(), createLines());
        assertThat(lines.isThereAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_column_is_a_nought() {
        given(board.getCells()).willReturn(columnWinNoughts());
        lines = new Lines(board.getCells(), createLines());
        assertThat(lines.isThereAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_diagonal_is_a_cross() {
        given(board.getCells()).willReturn(diagonalWinCrosses());
        lines = new Lines(board.getCells(), createLines());
        assertThat(lines.isThereAWinner(), is(true));
    }

    @Test public void
    set_win_state_to_true_when_each_cell_in_a_diagonal_is_a_nought() {
        given(board.getCells()).willReturn(diagonalWinNoughts());
        lines = new Lines(board.getCells(), createLines());
        assertThat(lines.isThereAWinner(), is(true));
    }

    @Test public void
    not_change_win_state_if_there_is_no_winning_combination() {
        given(board.getCells()).willReturn(noWin());
        lines = new Lines(board.getCells(), createLines());
        assertThat(lines.isThereAWinner(), is(false));
    }

    @Test public void
    determine_position_for_win_scenario() {
        lines = new Lines(winScenario(), createMockLines());

        given(mockedLine.identifyWinScenarioCellPosition(winScenario())).willReturn(
                null,
                new Position("3"),
                new Position("4"),
                new Position("5"),
                new Position("6"),
                new Position("7"),
                new Position("8"),
                new Position("9")
                );
        assertThat(lines.determineWinPosition(cells).getValue(), is("3"));
    }

    private List<Cell> winScenario() {
        cells = new ArrayList();
        for(int i=0; i<9; i++) {
            if(i == 0 || i == 1) {
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


    private List<Line> createLines() {

        List<Line> linesList = new ArrayList();

        Line row1 = new Line(0,1,2);
        Line row2 = new Line(3,4,5);
        Line row3 = new Line(6,7,8);
        Line column1 = new Line(0,3,6);
        Line column2 = new Line(1,4,7);
        Line column3 = new Line(2,5,8);
        Line diagonal1 = new Line(0,4,8);
        Line diagonal2 = new Line(2,4,6);

        linesList.add(row1);
        linesList.add(row2);
        linesList.add(row3);
        linesList.add(column1);
        linesList.add(column2);
        linesList.add(column3);
        linesList.add(diagonal1);
        linesList.add(diagonal2);

        return linesList;
    }


    private List<Line> createMockLines() {
        List<Line> mockLinesList = new ArrayList();

        for(int i=0; i<8; i++) {
            mockLinesList.add(mockedLine);
        }

        return mockLinesList;
    }

}
