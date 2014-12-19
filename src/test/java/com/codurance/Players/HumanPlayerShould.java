package com.codurance.Players;

import com.codurance.Console.Console;
import com.codurance.Board.Positions;
import com.codurance.Board.Cross;
import com.codurance.Board.Marker;
import com.codurance.Board.Position;
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
    @Mock Positions positions;
    @Mock Position position;

    @Test public void
    add_move_to_the_board() {
        Marker cross = new Cross();
        HumanPlayer humanPlayer = new HumanPlayer(cross);

        given(console.requestNextMove(any())).willReturn(position);

        humanPlayer.makeMove(positions, console);

        verify(positions).addMove(cross, position);
    }
}
