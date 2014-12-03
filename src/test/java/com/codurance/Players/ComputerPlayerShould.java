package com.codurance.Players;

import com.codurance.Board.Marker;
import com.codurance.Board.Nought;
import com.codurance.Board.Position;
import com.codurance.Board.Positions;
import com.codurance.ComputerStrategies.ComputerTurnGenerator;
import com.codurance.Console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerShould {

    @Mock Position position;
    @Mock Positions positions;
    @Mock Console console;
    @Mock ComputerTurnGenerator computerTurnGenerator;

    @Test public void
    add_move_to_the_board() {
        given(computerTurnGenerator.calculateNextMove(positions)).willReturn(position);

        Marker noughtMarker = new Nought();
        ComputerPlayer computerPlayer = new ComputerPlayer(computerTurnGenerator, noughtMarker);

        computerPlayer.makeMove(positions, console);

        verify(console).computerMoveConfirmation();
        verify(positions).addMove(noughtMarker, position);
    }
}
