package com.codurance.Game;

import com.codurance.Console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TicTacToeShould {

    @Mock GameType gameType;
    @Mock Game game;
    @Mock Console console;


    @Test public void
    load_a_new_game() {
        TicTacToe ticTacToe = new TicTacToe(console, game);

        given(console.requestGameType()).willReturn(gameType);

        ticTacToe.loadGameType();

        verify(game).start(gameType);
    }
}
