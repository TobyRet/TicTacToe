package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Cell.CellReference;
import com.codurance.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerShould {

    @Mock CellReference cellReference;
    @Mock Board board;
    @Mock
    Console console;
    @Mock
    ComputerPlayerStrategies computerStrategies;

    @Test public void
    add_move_to_the_board() {
        given(computerStrategies.requestNextMove()).willReturn(cellReference);
        ComputerPlayer computerPlayer = new ComputerPlayer(board, console, computerStrategies);
        computerPlayer.makeMove();
        verify(board).addMove(cellReference);
    }
}
