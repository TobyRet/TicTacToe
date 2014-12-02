package com.codurance.Game;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTypeShould {

    @Test public void
    confirm_a_gameType() {
        GameType gameTypeSingle = new GameType("S");
        assertThat(gameTypeSingle.isSinglePlayer(), is(true));
        assertThat(gameTypeSingle.isMultiPlayer(), is(false));

        GameType gameTypeMulti = new GameType("M");
        assertThat(gameTypeMulti.isMultiPlayer(), is(true));
        assertThat(gameTypeMulti.isSinglePlayer(), is(false));
    }
}
