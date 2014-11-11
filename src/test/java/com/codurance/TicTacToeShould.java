package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TicTacToeShould {

    private static final String MULTI_PLAYER = "M";
    private static final String SINGLE_PLAYER = "S";
    private static final String INVALID_CHOICE = "T";
    private TicTacToe ticTacToe;
    @Mock Console console;
    @Mock TwoPlayerGame twoPlayerGame;
    @Mock SinglePlayerGame singlePlayerGame;

    @Before
    public void initialise() {
        ticTacToe = new TicTacToe(console, singlePlayerGame, twoPlayerGame);
    }

    @Test public void
    load_a_new_single_player_game() throws IOException {
        given(console.requestGameType()).willReturn(SINGLE_PLAYER);

        ticTacToe.loadGame();

        verify(singlePlayerGame).start();
        verify(twoPlayerGame, never()).start();
    }

    @Test public void
    load_a_new_two_player_game() throws IOException {
        given(console.requestGameType()).willReturn(MULTI_PLAYER);

        ticTacToe.loadGame();

        verify(twoPlayerGame).start();
        verify(singlePlayerGame, never()).start();
    }

    @Test public void
    provide_error_message_if_game_type_choice_is_invalid() throws IOException {
        given(console.requestGameType()).willReturn(INVALID_CHOICE);

        ticTacToe.loadGame();

        verify(twoPlayerGame, never()).start();
        verify(singlePlayerGame, never()).start();
        verify(console).printInvalidGameType();
    }
}
