package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HumanPlayerShould {

    @Mock Console console;
    @Mock Board board;

    @Test public void
    add_move_to_the_board() {
        HumanPlayer humanPlayer = new HumanPlayer(BoardMarker.CROSS, console);

        given(console.read()).willReturn("0");

        humanPlayer.addMoveTo(board);

        verify(console).read();
        verify(board).addMove(BoardMarker.CROSS, "0");
    }
}
