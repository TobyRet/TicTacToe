package com.codurance.Players;

import com.codurance.Cell.CellReference;
import com.codurance.ComputerStrategies.RandomStrategy;
import com.codurance.Game.Lines;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RandomStrategyShould {
    @Mock Lines lines;
    @Mock CellReference mockedCellReference;
    private RandomStrategy randomStrategy;

    @Test public void
    return_a_random_cell_position() {
        randomStrategy = new RandomStrategy(lines);
        given(lines.getFirstAvailableMove()).willReturn(mockedCellReference);
        randomStrategy.execute();
    }
}
