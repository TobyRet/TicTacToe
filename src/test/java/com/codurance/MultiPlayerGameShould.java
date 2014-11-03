package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
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

//    @Test public void
//    print_empty_board_to_console() throws IOException {
//        given(board.getBoardForPrinting()).willReturn(
//                "- - - \n" +
//                "- - - \n" +
//                "- - -"
//        );
//
//        //given(console.requestNextMove(player1)).willReturn(null);
//        game.start();
//
//        verify(console).printEmptyBoard(board.getBoardForPrinting());
//
//    }

    @Test public void
    add_player1_move_to_the_board() throws IOException {
       given(console.requestNextMove(game.getCurrentPlayer())).willReturn("2");
       game.start();
       verify(board).addMove(1, player1);
       verify(console, times(2)).printBoard(board.getBoardForPrinting());
    }

    @Test public void
    change_currentPlayer_to_player_2_after_player_1_has_made_move() throws IOException {
        assertThat(game.getCurrentPlayer(), is(player1));
        game.play("1");
        assertThat(game.getCurrentPlayer(), is(player2));
    }
}