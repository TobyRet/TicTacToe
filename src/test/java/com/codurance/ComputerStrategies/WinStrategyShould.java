//package com.codurance.ComputerStrategies;
//
//import com.codurance.Board.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class WinStrategyShould {
//
//    private WinStrategy winStrategy;
//    private Marker marker;
//    @Mock Lines lines;
//    @Mock Positions positions;
//    @Mock Position position;
//
//    @Test public void
//    complete_a_line_to_win_the_game() {
//        marker = new Cross();
//        winStrategy = new WinStrategy(lines);
//        winStrategy.execute(marker, positions);
//        verify(positions).addMove(any(Cross.class), any(Position.class));
//    }
//
//    @Test public void
//    know_if_a_win_strategy_is_possible() {
//        marker = new Cross();
//        winStrategy = new WinStrategy(lines);
//        given(lines.completeForWin(positions, marker)).willReturn(1);
//        assertThat(winStrategy.isFeasible(marker, positions), is(true));
//    }
//}
