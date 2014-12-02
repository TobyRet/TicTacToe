package com.codurance.Positions;

import com.codurance.Cell.Position;
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
    confirm_that_it_is_empty_if_there_are_spaces_available() {
        Position playMove = new Position("1");
        positions.addMove(playMove);
        assertThat(positions.areEmpty(), is(true));
    }

    @Test public void
    record_a_players_position() {
        Positions positions = new Positions();

        for(int i = 0; i <= 9; i++) {
            Position position = new Position(null);
            positions.addMove(position);
        }

        assertThat(positions.areEmpty(), is(false));
    }
}
