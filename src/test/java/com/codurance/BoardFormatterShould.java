package com.codurance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardFormatterShould {

    private List<Cell> cells;
    private String EMPTY_BOARD = "\n- - -\n" + "- - -\n" + "- - -\n";

    @Test public void
    format_cells_for_printing() {
        createCells();
        BoardFormatter boardFormatter = new BoardFormatter();
        assertThat(boardFormatter.format(cells), is(EMPTY_BOARD));
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
