package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Board.BoardMarker;
import com.codurance.Cell.Position;
import com.codurance.ComputerStrategies.ComputerMove;
import com.codurance.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerShould {

    @Mock
    Position position;
    @Mock Board board;
    @Mock Console console;
    @Mock
    ComputerMove computerStrategies;
    @Mock BoardMarker boardMarker;

    @Test public void
    add_move_to_the_board() {
        given(computerStrategies.calculateNextMove()).willReturn(position);
        ComputerPlayer computerPlayer = new ComputerPlayer(computerStrategies, boardMarker);
        computerPlayer.makeMove(board, console);
        verify(console).computerMoveConfirmation();
        verify(board).addMove(position, boardMarker);
    }
}
