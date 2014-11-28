package com.codurance.Game;

import com.codurance.Board.Board;
import com.codurance.Console;
import com.codurance.Players.ComputerPlayer;
import com.codurance.Players.HumanPlayer;
import com.codurance.Players.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
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
    @Mock Lines lines;
    private Game game;
    private List<Player> allPlayers;
    private String MULTI_PLAYER = "M";
    private final String SINGLE_PLAYER = "S";
    private final String EMPTY_BOARD = "---\n" + "---\n" + "---";

    @Before
    public void initialise() {
        createMockPlayers();
        game = new Game(allPlayers, board, console, lines);
    }

    @Test public void
    loads_human_players_when_multi_player_game() {
        given(gameType.getValue()).willReturn(MULTI_PLAYER);
        given(lines.checkIfThereIsAWinner()).willReturn(true);
        game.start(gameType);
        assertThat(game.getGamePlayers(), hasItems(humanPlayer1, humanPlayer2));
        assertThat(game.getGamePlayers(), not(hasItem(computerPlayer)));
    }

    @Test public void
    loads_computer_player_and_one_human_player_when_single_game() {
        given(gameType.getValue()).willReturn(SINGLE_PLAYER);
        given(lines.checkIfThereIsAWinner()).willReturn(true);
        game.start(gameType);
        assertThat(game.getGamePlayers(), hasItems(humanPlayer1, computerPlayer));
        assertThat(game.getGamePlayers(), not(hasItem(humanPlayer2)));
    }

    @Test public void
    loads_an_empty_board() {
        given(gameType.getValue()).willReturn(SINGLE_PLAYER);
        given(board.getBoardForPrinting()).willReturn(EMPTY_BOARD);
        given(lines.checkIfThereIsAWinner()).willReturn(true);
        game.start(gameType);
        verify(console).printBoard(EMPTY_BOARD);
    }

    @Test public void
    start_multi_player_game_and_allow_players_to_make_moves() {
        given(gameType.getValue()).willReturn(MULTI_PLAYER);
        given(lines.checkIfThereIsAWinner()).willReturn(false, false, true);
        game.start(gameType);
        verify(humanPlayer1).makeMove(board, console);
        verify(humanPlayer2).makeMove(board, console);
    }

    @Test public void
    start_single_player_game_and_allow_players_to_make_moves() {
        given(gameType.getValue()).willReturn(SINGLE_PLAYER);
        given(lines.checkIfThereIsAWinner()).willReturn(false, false, true);
        game.start(gameType);
        verify(humanPlayer1).makeMove(board, console);
        verify(computerPlayer).makeMove(board, console);
    }

    @Test public void
    stop_game_if_a_player_wins() {
        given(gameType.getValue()).willReturn(MULTI_PLAYER);
        given(lines.checkIfThereIsAWinner()).willReturn(false, false, false, false, false, true);
        game.start(gameType);
        verify(console).printWinner(humanPlayer1);
    }

    @Test public void
    stop_game_if_a_draw() {
        given(gameType.getValue()).willReturn(MULTI_PLAYER);
        given(lines.checkIfThereIsAWinner()).willReturn(false, false, false, false, false, false, false, false, false, false);
        given(board.isEmpty()).willReturn(false, false, false, false, false, false, false, false, false, true);
        game.start(gameType);
        verify(console).printDraw();
    }

    private void createMockPlayers() {
        allPlayers = new ArrayList();
        allPlayers.add(humanPlayer1);
        allPlayers.add(humanPlayer2);
        allPlayers.add(computerPlayer);
    }
}
