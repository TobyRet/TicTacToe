package com.codurance.Players;

import com.codurance.Cell.CellReference;
import com.codurance.ComputerStrategies.ComputerPlayerStrategies;
import com.codurance.ComputerStrategies.RandomStrategy;
import com.codurance.Game.Lines;
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
    @Mock CellReference mockedCellReference;
    @Mock Lines lines;
    @Mock
    RandomStrategy randomStrategy;

    @Test public void
    return_a_random_move() {

        computerPlayerStrategies = new ComputerPlayerStrategies(randomStrategy);
        given(randomStrategy.execute()).willReturn(mockedCellReference);
        assertThat(computerPlayerStrategies.requestNextMove(), is(mockedCellReference));
    }
}
