package com.codurance.Board;

import com.codurance.Console.Formatter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BoardShould {

    private Board board;
    @Mock Formatter formatter;
    @Mock Lines lines;

    @Before
    public void initialise() {
        board = new Board(formatter, lines);
    }

    

//    @Test public void
//    have_empty_positions_when_initialised() {
//        assertThat(board.areEmpty(), is(true));
//    }
//
//    @Test public void
//    record_a_players_position() {
//        Position position = new Position(1);
//
//        board.addMove(BoardMarker.CROSS, position);
//
//        assertThat(board.areEmpty(), is(true));
//    }
//
//    @Test public void
//    confirm_that_it_is_not_empty_if_there_are_no_spaces_available() {
//        Position position = new Position(1);
//
//        for(int i=0; i<9; i++) {
//            board.addMove(BoardMarker.CROSS, position);
//        }
//
//        assertThat(board.areEmpty(), is(true));
//    }
//
//    @Test public void
//    print_positions_to_the_console() {
//        Console console = mock(Console.class);
//
//        board.print(console);
//
//        verify(formatter).print(any(Console.class), anyList());
//    }
//
//    @Test public void
//    check_if_there_is_a_winner() {
//        given(lines.checkLinesForWinner(any())).willReturn(true);
//        assertThat(board.checkForWinner(), is(true));
//    }
}
