package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Cell.Position;
import com.codurance.ComputerStrategies.ComputerPlayerStrategies;
import com.codurance.ComputerStrategies.RandomStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerStrategiesShould {

    private ComputerPlayerStrategies computerPlayerStrategies;
    @Mock
    Position mockedPosition;
    @Mock Board board;
    @Mock RandomStrategy randomStrategy;

    @Test public void
    return_a_random_move() {

        computerPlayerStrategies = new ComputerPlayerStrategies(randomStrategy, board);
        given(randomStrategy.execute(board.getCells())).willReturn(mockedPosition);
        assertThat(computerPlayerStrategies.requestNextMove(), is(mockedPosition));
    }
}
