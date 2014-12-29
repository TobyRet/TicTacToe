package com.codurance.Players;

import com.codurance.Board.Position;
import com.codurance.Board.Board;
import com.codurance.Console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HumanPlayerShould {

    @Mock Console console;
    @Mock
    Board board;
    @Mock Position position;

    @Test public void
    add_move_to_the_board() {
        HumanPlayer humanPlayer = new HumanPlayer(BoardMarker.NOUGHT);

        given(console.requestNextMove(any())).willReturn(position);

        humanPlayer.addMoveTo(board);

        verify(board).addMove(BoardMarker.NOUGHT, position);
    }
}
