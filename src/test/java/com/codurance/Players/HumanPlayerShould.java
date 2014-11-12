package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Board.BoardMarker;
import com.codurance.Cell.CellReference;
import com.codurance.Console;
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
    @Mock Board board;
    @Mock PlayerName playerName;
    @Mock CellReference cellReference;
    @Mock BoardMarker boardMarker;

    @Test public void
    add_move_to_the_board() {
        given(console.requestNextMove(any())).willReturn(cellReference);
        HumanPlayer humanPlayer = new HumanPlayer(playerName, boardMarker);
        humanPlayer.makeMove(board, console);
        verify(board).addMove(cellReference, boardMarker);
    }
}
