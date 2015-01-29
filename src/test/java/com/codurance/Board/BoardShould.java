package com.codurance.Board;

import com.codurance.Console.Formatter;
import com.codurance.Players.BoardMarker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BoardShould {

    private static final String EMPTY_FORMATTED_BOARD = "_ _ _ \n_ _ _ \n_ _ _ \n";
    private Board board;
    @Mock LinesChecker linesChecker;
	@Mock Formatter formatter;

    @Before
    public void initialise() {
        board = new Board(linesChecker, formatter);
    }

    @Test public void
    initialise_an_empty_board() {
        assertThat(board.isEmpty(), is(true));
    }

    @Test public void
    confirm_if_there_is_a_winner() {
        given(linesChecker.checkForWin(board.getBoard())).willReturn(true);

        assertThat(board.isThereAWinner(), is(true));
        verify(linesChecker).checkForWin(board.getBoard());
    }

    @Test public void
    add_a_players_move() {
        board.addMove(BoardMarker.CROSS, "1");
        assertThat(board.isEmpty(), is(false));
    }

    @Test public void
    confirm_when_all_positions_have_values() {
        for(int i=1; i<10; i++) {
            board.addMove(BoardMarker.CROSS, "" + i);
        }
        assertThat(board.isFull(), is(true));
    }

    @Test public void
    return_an_empty_formatted_board() {
	    given(formatter.format(board.getBoard())).willReturn(EMPTY_FORMATTED_BOARD);

        assertThat(board.getBoardForPrinting(), is(EMPTY_FORMATTED_BOARD));
	    verify(formatter).format(board.getBoard());
    }
}
