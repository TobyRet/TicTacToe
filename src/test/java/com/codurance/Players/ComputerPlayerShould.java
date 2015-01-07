package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Board.Position;
import com.codurance.ComputerStrategies.ComputerTurnGenerator;
import com.codurance.Console.Console;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerShould {

    @Mock Position position;
    @Mock Board board;
    @Mock Console console;
    @Mock ComputerTurnGenerator computerTurnGenerator;

    @Ignore
    @Test public void
    add_move_to_the_board() {
        ComputerPlayer computerPlayer = new ComputerPlayer(computerTurnGenerator, BoardMarker.NOUGHT);

        computerPlayer.addMoveTo(board);

        verify(console).computerMoveConfirmation();
        verify(computerTurnGenerator).calculateNextMove(BoardMarker.NOUGHT, board);
    }
}
