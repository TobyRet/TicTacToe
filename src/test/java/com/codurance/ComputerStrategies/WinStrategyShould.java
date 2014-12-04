package com.codurance.ComputerStrategies;

import com.codurance.Board.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WinStrategyShould {

    private WinStrategy winStrategy;
    private Marker marker;
    @Mock Lines lines;
    @Mock Positions positions;
    @Mock Position position;

    @Test public void
    complete_a_line_to_win_the_game() {
        marker = new Cross();
        winStrategy = new WinStrategy(lines);
        winStrategy.execute(marker, positions);
        verify(positions).addMove(any(Cross.class), any(Position.class));
    }

}
