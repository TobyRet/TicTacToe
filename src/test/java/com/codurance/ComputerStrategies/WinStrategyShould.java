//package com.codurance.ComputerStrategies;
//
//import com.codurance.Board.Board;
//import com.codurance.Cell.Cell;
//import com.codurance.Positions.Position;
//import com.codurance.Game.Lines;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.mockito.BDDMockito.given;
//
//@RunWith(MockitoJUnitRunner.class)
//public class WinStrategyShould {
//
//    private List<Cell> boardCells;
//    @Mock Lines lines;
//    @Mock Board board;
//    @Mock Position mockedPosition;
//
//    @Test public void
//    complete_a_line_for_a_win() {
//        WinStrategy winStrategy = new WinStrategy(lines);
//        given(lines.determineWinPosition(boardWithWinScenario())).willReturn(mockedPosition);
//        assertThat(winStrategy.execute(boardCells), is(mockedPosition));
//    }
//
//    private List<Cell> boardWithWinScenario() {
//        boardCells = new ArrayList();
//
//        for(int i=0; i<2; i++) {
//            Cell cell = new Cell();
//            cell.setValue("X");
//            boardCells.add(cell);
//        }
//
//        for(int i=0; i<7; i++) {
//            Cell cell = new Cell();
//            boardCells.add(cell);
//        }
//
//        return boardCells;
//    }
//}
