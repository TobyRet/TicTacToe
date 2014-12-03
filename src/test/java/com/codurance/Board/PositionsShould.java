package com.codurance.Board;

import com.codurance.Console.Formatter;
import com.codurance.Console.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PositionsShould {

    private Positions positions;
    @Mock Formatter formatter;

    @Before
    public void initialise() {
        positions = new Positions(formatter);
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

        verify(formatter).print(Matchers.any(Console.class), anyList());
    }
}
