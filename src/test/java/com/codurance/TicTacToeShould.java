package com.codurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TicTacToeShould {

    private static final String MULTI_PLAYER = "M";
    @Mock MultiPlayerGame multiPlayerGame;
    @Mock Console console;

    @Test public void
    load_a_new_2_player_game() throws IOException {
        TicTacToe ticTacToe = new TicTacToe(console);

        given(console.requestGameType()).willReturn(MULTI_PLAYER);
        ticTacToe.loadGameType();

//        verify(multiPlayerGame).start();
    }
}
