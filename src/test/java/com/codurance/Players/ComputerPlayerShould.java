package com.codurance.Players;

import com.codurance.Board.*;
import com.codurance.ComputerStrategies.ComputerTurnGenerator;
import com.codurance.Console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerShould {

    @Mock Position position;
    @Mock Positions positions;
    @Mock Console console;
    @Mock ComputerTurnGenerator computerTurnGenerator;

    @Test public void
    add_move_to_the_board() {
        Marker noughtMarker = new Nought();
        ComputerPlayer computerPlayer = new ComputerPlayer(computerTurnGenerator, noughtMarker);

        computerPlayer.makeMove(positions, console);

        verify(console).computerMoveConfirmation();
        verify(computerTurnGenerator).calculateNextMove(noughtMarker, positions);
    }
}
