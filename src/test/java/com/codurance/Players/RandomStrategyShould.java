package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Cell.Cell;
import com.codurance.Cell.Position;
import com.codurance.ComputerStrategies.RandomStrategy;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RandomStrategyShould {
    @Mock Board board;
    private RandomStrategy randomStrategy;
    private List<Cell> cells;

    @Test public void
    return_first_position_if_a_blank_board() {
        randomStrategy = new RandomStrategy();
        given(board.getCells()).willReturn(blankBoard());
        assertThat(randomStrategy.execute(board.getCells()), is(Matchers.any(Position.class)));
    }

    @Test public void
    return_second_position_if_first_position_is_occupied() {
        randomStrategy = new RandomStrategy();
        given(board.getCells()).willReturn(firstCellOccupied());
        assertThat(randomStrategy.execute(board.getCells()).getValue(), is("2"));
    }

    private List<Cell> firstCellOccupied() {
        cells = new ArrayList();

        Cell occupiedCell = new Cell();
        occupiedCell.setValue("X");
        cells.add(occupiedCell);

        for(int i=0; i<8; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
        return cells;
    }

    private List<Cell> blankBoard() {
        cells = new ArrayList();

        for(int i=0; i<9; i++) {
            Cell cell = new Cell();
            cells.add(cell);
        }
        return cells;
    }

}
