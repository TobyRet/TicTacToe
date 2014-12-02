package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Board.BoardMarker;
import com.codurance.Cell.Position;
import com.codurance.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HumanPlayerShould {

    @Mock Console console;
    @Mock Board board;
    @Mock PlayerName playerName;
    @Mock
    Position position;
    @Mock BoardMarker boardMarker;

    @Test public void
    add_move_to_the_board() {
//        given(console.requestNextMove(any())).willReturn(position);
//        HumanPlayer humanPlayer = new HumanPlayer(playerName, boardMarker);
//        humanPlayer.makeMove(board, console);
//        verify(board).addMove(position, boardMarker);
    }
}
