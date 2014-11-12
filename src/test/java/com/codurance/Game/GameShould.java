package com.codurance.Game;

import com.codurance.Board.Board;
import com.codurance.Console;
import com.codurance.Game.Game;
import com.codurance.Game.GameLogic;
import com.codurance.Game.GameType;
import com.codurance.Players.ComputerPlayer;
import com.codurance.Players.HumanPlayer;
import com.codurance.Players.Player;
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

    @Mock
    HumanPlayer humanPlayer1;
    @Mock HumanPlayer humanPlayer2;
    @Mock
    ComputerPlayer computerPlayer;
    @Mock
    GameType gameType;
    @Mock
    Board board;
    @Mock
    Console console;
    @Mock
    GameLogic gameLogic;
    private Game game;
    private List<Player> allPlayers;
    private String MULTI_PLAYER = "M";
    private final String SINGLE_PLAYER = "S";
    private final String EMPTY_BOARD = "---\n" + "---\n" + "---";

    @Before
    public void initialise() throws IOException {
        createMockPlayers();
        game = new Game(allPlayers, board, console);
    }

    @Test public void
    loads_human_players_when_multi_player_game() {
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

    @Test public void
    start_multi_player_game_and_allow_players_to_make_moves() {
        given(gameType.getValue()).willReturn(MULTI_PLAYER);
        game.start(gameType);
        verify(humanPlayer1).makeMove();
        verify(humanPlayer2).makeMove();
    }

    @Test public void
    start_single_player_game_and_allow_players_to_make_moves() {
        given(gameType.getValue()).willReturn(SINGLE_PLAYER);
        game.start(gameType);
        verify(humanPlayer1).makeMove();
        verify(computerPlayer).makeMove();
    }

    private void createMockPlayers() {
        allPlayers = new ArrayList();
        allPlayers.add(humanPlayer1);
        allPlayers.add(humanPlayer2);
        allPlayers.add(computerPlayer);
    }
}
