package com.codurance;

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

    private static final String EMPTY_BOARD = "---------" ;
    @Mock Cell cell;

    @Test public void
    initialise_nine_empty_cells() {
        List<Cell> cells = new ArrayList();

        for(int i=0; i<9; i++) cells.add(cell);

        Board board = new Board(cells);
        given(cell.getValue()).willReturn("-");

        assertThat(board.getState(), is(EMPTY_BOARD));
    }

}