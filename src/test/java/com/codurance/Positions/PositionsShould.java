package com.codurance.Positions;

import com.codurance.Game.Positions;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PositionsShould {

    private Positions positions;

    @Before
    public void initialise() {
        positions = new Positions();
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
}
