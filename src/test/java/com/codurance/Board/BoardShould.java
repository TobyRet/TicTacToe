package com.codurance.Board;

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

    private Board board;
    @Mock
    LinesChecker linesChecker;

    @Before
    public void initialise() {
        board = new Board(linesChecker);
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
}
