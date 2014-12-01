package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Cell.Position;
import com.codurance.ComputerStrategies.ComputerMove;
import com.codurance.ComputerStrategies.ComputerPlayerStrategy;
import com.codurance.ComputerStrategies.RandomStrategy;
import com.codurance.ComputerStrategies.WinStrategy;
import org.junit.Before;
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
public class ComputerPlayerStrategiesShould {

    private ComputerMove computerPlayerStrategies;
    @Mock Position mockedPosition;
    @Mock Board board;
    @Mock RandomStrategy randomStrategy;
    @Mock
    WinStrategy winStrategy;
    private List<ComputerPlayerStrategy> computerStrategyList;

    @Before
    public void initialise() {
        addStrategiesToList();
        computerPlayerStrategies = new ComputerMove(computerStrategyList, board);
    }


    @Test public void
    return_next_available_empty_cell() {
        given(randomStrategy.execute(board.getCells())).willReturn(mockedPosition);
        given(winStrategy.execute(board.getCells())).willReturn(null);
        assertThat(computerPlayerStrategies.calculateNextMove(), is(mockedPosition));
    }

    @Test public void
    complete_a_line_to_win_the_game(){
        given(winStrategy.execute(board.getCells())).willReturn(mockedPosition);
        given(randomStrategy.execute(board.getCells())).willReturn(null);
        assertThat(computerPlayerStrategies.calculateNextMove(), is(mockedPosition));
    }

    private void addStrategiesToList() {
        computerStrategyList = new ArrayList();
        computerStrategyList.add(winStrategy);
        computerStrategyList.add(randomStrategy);
    }
}
