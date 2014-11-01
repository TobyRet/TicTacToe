package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MultiPlayerGameShould {

    @Mock Player player1;
    @Mock Player player2;
    @Mock Board board;
    @Mock Console console;
    private MultiPlayerGame game;
    private List<Player> players;

    @Before
    public void initialise() {

        players = new ArrayList();
        players.add(player1);
        players.add(player2);
        game = new MultiPlayerGame(players, board, console);
    }

    @Test public void
    print_empty_board_to_console() {
        given(board.getBoardForPrinting()).willReturn(
                "- - - \n" +
                "- - - \n" +
                "- - -"
        );

        game.start();

        verify(console).printBoard(board.getBoardForPrinting());
        verify(console).printPlayerInstruction(player1);
    }

    @Test public void
    add_player1_move_to_the_board() {
       game.play(1);
       verify(board).addMove(1, player1);
       verify(console).printBoard(board.getBoardForPrinting());
    }

    @Test public void
    change_currentPlayer_to_player_2_after_player_1_has_made_move() {
        assertThat(game.getCurrentPlayer(), is(player1));
        game.play(1);
        assertThat(game.getCurrentPlayer(), is(player2));
    }
}