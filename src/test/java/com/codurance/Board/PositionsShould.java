package com.codurance.Board;

import com.codurance.Console.Console;
import com.codurance.Console.Formatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PositionsShould {

    private Positions positions;
    @Mock Formatter formatter;
    @Mock Lines lines;

    @Before
    public void initialise() {
        positions = new Positions(formatter, lines);
    }

    @Test public void
    have_empty_positions_when_initialised() {
        assertThat(positions.areEmpty(), is(true));
    }

    @Test public void
    record_a_players_position() {
        Marker cross = new Cross();
        Position position = new Position(1);

        positions.addMove(cross, position);

        assertThat(positions.areEmpty(), is(true));
    }

    @Test public void
    confirm_that_it_is_not_empty_if_there_are_no_spaces_available() {
        Position position = new Position(1);

        for(int i=0; i<9; i++) {
            Marker cross = new Cross();
            positions.addMove(cross, position);
        }

        assertThat(positions.areEmpty(), is(true));
    }

    @Test public void
    print_positions_to_the_console() {
        Console console = mock(Console.class);

        positions.print(console);

        verify(formatter).print(any(Console.class), anyList());
    }

    @Test public void
    check_if_there_is_a_winner() {
        given(lines.checkLinesForWinner(any())).willReturn(true);
        assertThat(positions.checkForWinner(), is(true));
    }
}
