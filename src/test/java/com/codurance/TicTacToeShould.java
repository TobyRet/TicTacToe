package com.codurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TicTacToeShould {

    @Mock GameType gameType;
    @Mock Game game;
    @Mock Console console;


    @Test public void
    load_a_new_2_player_game() {
        TicTacToe ticTacToe = new TicTacToe(console, game);

        given(console.requestGameType()).willReturn(gameType);
        given(console.requestNextMove(any())).willReturn("1", "2", "3", "4", "5", "6", "7", "8", "9");

        ticTacToe.loadGameType();

        verify(game).start(gameType);
    }
}
