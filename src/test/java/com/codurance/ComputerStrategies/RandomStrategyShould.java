//package com.codurance.ComputerStrategies;
//
//import com.codurance.Board.Cross;
//import com.codurance.Board.Position;
//import com.codurance.Board.Positions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Matchers;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class RandomStrategyShould {
//    private RandomStrategy randomStrategy;
//    @Mock Positions positions;
//    @Mock Random randomGenerator;
//    @Mock Cross marker;
//
//    @Test public void
//    make_random_move_in_empty_position() {
//        List<String> mockedPositions = new ArrayList<>();
//
//        for(int i=0; i<9; i++) {
//            mockedPositions.add("-");
//        }
//
//        given(randomGenerator.nextInt(anyInt())).willReturn(0);
//
//        randomStrategy = new RandomStrategy(randomGenerator);
//
//        randomStrategy.execute(marker, positions);
//
//        verify(positions).addMove(Matchers.any(Cross.class), Matchers.any(Position.class));
//    }
//}
