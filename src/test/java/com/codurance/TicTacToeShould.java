package com.codurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TicTacToeShould {

    private static final String MULTI_PLAYER = "M";
    @Mock MultiPlayerGame multiPlayerGame;
    @Mock Console console;


    @Test public void
    load_a_new_2_player_game() throws IOException {
        TicTacToe ticTacToe = new TicTacToe(console, multiPlayerGame);

        given(console.requestGameType()).willReturn(MULTI_PLAYER);
        given(console.requestNextMove(any())).willReturn("1", "2", "3", "4", "5", "6", "7", "8", "9");

        ticTacToe.loadGameType();

        verify(multiPlayerGame).start();
    }
}
