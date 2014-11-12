package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameShould {

    @Mock HumanPlayer humanPlayer1;
    @Mock HumanPlayer humanPlayer2;
    @Mock ComputerPlayer computerPlayer;
    @Mock GameType gameType;
    @Mock Board board;
    @Mock Console console;
    @Mock GameLogic gameLogic;
    private Game game;
    private List<Player> allPlayers;
    private String MULTI_PLAYER = "M";
    private final String SINGLE_PLAYER = "S";
    private final String EMPTY_BOARD = "---\n" + "---\n" + "---";

    @Before
    public void initialise() throws IOException {
        createMockPlayers();
        game = new Game(allPlayers, gameLogic, board, console);
//        given(console.requestNextMove(any())).willReturn("1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    @Test public void
    loads_human_players_when_multiplayer_game() {
        given(gameType.getValue()).willReturn(MULTI_PLAYER);
        game.start(gameType);
        assertThat(game.getGamePlayers(), hasItems(humanPlayer1, humanPlayer2));
        assertThat(game.getGamePlayers(), not(hasItem(computerPlayer)));
    }

    @Test public void
    loads_computer_player_and_one_human_player_when_single_game() {
        given(gameType.getValue()).willReturn(SINGLE_PLAYER);
        game.start(gameType);
        assertThat(game.getGamePlayers(), hasItems(humanPlayer1, computerPlayer));
        assertThat(game.getGamePlayers(), not(hasItem(humanPlayer2)));
    }

    @Test public void
    loads_an_empty_board() {
        given(board.getBoardForPrinting()).willReturn(EMPTY_BOARD);
        game.start(gameType);
        verify(console).printBoard(EMPTY_BOARD);
    }

//    @Test public void
//    add_player1_move_to_the_board() throws IOException {
//       game.start(gameType);
//       verify(board).addMove(0, humanPlayer1);
//       verify(console, times(10)).printBoard(board.getBoardForPrinting());
//    }
//
//    @Test public void
//    change_currentPlayer_to_player_2_after_player_1_has_made_move() throws IOException {
//        assertThat(game.getCurrentPlayer(), is(humanPlayer1));
//        game.start(gameType);
//        assertThat(game.getCurrentPlayer(), is(humanPlayer2));
//    }
//
//    @Test public void
//    stop_game_if_a_player_wins_the_game() throws IOException {
//        given(gameLogic.checkForWin()).willReturn(true);
//        game.start(gameType);
//        verify(console).printWinner(humanPlayer1);
//    }

    private void createMockPlayers() {
        allPlayers = new ArrayList();
        allPlayers.add(humanPlayer1);
        allPlayers.add(humanPlayer2);
        allPlayers.add(computerPlayer);
    }
}
