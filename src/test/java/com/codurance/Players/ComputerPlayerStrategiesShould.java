package com.codurance.Players;

import com.codurance.Cell.CellReference;
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
    @Mock CellReference cellReference;
    @Mock Lines lines;

    @Test public void
    play_win_strategy() {
        computerPlayerStrategies = new ComputerPlayerStrategies(lines);

        given(lines.calculateMoveForComputer()).willReturn(cellReference);

        assertThat(computerPlayerStrategies.requestNextMove(), is(cellReference));
    }
}
