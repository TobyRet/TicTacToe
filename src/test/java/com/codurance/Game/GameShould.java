package com.codurance.Game;

import com.codurance.Board.Lines;
import com.codurance.Board.Marker;
import com.codurance.Board.Nought;
import com.codurance.Board.Positions;
import com.codurance.ComputerStrategies.ComputerTurnGenerator;
import com.codurance.Console.Console;
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

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameShould {

    private Player humanPlayer1;
    private Player humanPlayer2;
    private Player computerPlayer;
    private Game game;
    private List<Player> allPlayers;
    private List<Player> allMockPlayers;
    private ComputerTurnGenerator computerTurnGenerator;
    @Mock Positions positions;
    @Mock GameType gameType;
    @Mock Console console;
    @Mock Lines lines;
    @Mock Positions mockPositions;
    @Mock Player mockHumanPlayer1;
    @Mock Player mockHumanPlayer2;
    @Mock Player mockComputerPlayer;

    @Before
    public void initialise() {
        createPlayers();
        game = new Game(allPlayers, mockPositions, console, lines);
    }

    @Test public void
    loads_human_players_when_multi_player_game() {
        given(gameType.isMultiPlayer()).willReturn(true);
        given(positions.checkForWinner()).willReturn(true);

        game.start(gameType);

        assertThat(game.getGamePlayers(), hasItems(humanPlayer1, humanPlayer2));
        assertThat(game.getGamePlayers(), not(hasItem(computerPlayer)));
    }

    @Test public void
    loads_computer_player_and_one_human_player_when_single_game() {
        given(gameType.isSinglePlayer()).willReturn(true);
        given(positions.checkForWinner()).willReturn(true);

        game.start(gameType);

        assertThat(game.getGamePlayers(), hasItems(humanPlayer1, computerPlayer));
        assertThat(game.getGamePlayers(), not(hasItem(humanPlayer2)));
    }

    @Test public void
    prints_board_to_screen() {
        given(gameType.isSinglePlayer()).willReturn(true);

        game.start(gameType);

        verify(mockPositions).print(console);
    }

    @Test public void
    start_multi_player_game_and_allow_players_to_make_moves() {
        createMockPlayers();

        game = new Game(allMockPlayers, positions, console, lines);

        given(gameType.isMultiPlayer()).willReturn(true);
        given(positions.checkForWinner()).willReturn(false, false, true);
        given(positions.areEmpty()).willReturn(true, true, true);

        game.start(gameType);

        verify(mockHumanPlayer1).makeMove(positions, console);
        verify(mockHumanPlayer2).makeMove(positions, console);
    }

    @Test public void
    start_single_player_game_and_allow_players_to_make_moves() {
        createMockPlayers();

        game = new Game(allMockPlayers, positions, console, lines);

        given(gameType.isSinglePlayer()).willReturn(true);
        given(positions.checkForWinner()).willReturn(false, false, true);
        given(positions.areEmpty()).willReturn(true, true, true);

        game.start(gameType);

        verify(mockHumanPlayer1).makeMove(positions, console);
        verify(mockComputerPlayer).makeMove(positions, console);
    }

    @Test public void
    announce_winner_if_a_player_wins() {
        createPlayers();

        game = new Game(allPlayers, positions, console, lines);

        given(gameType.isMultiPlayer()).willReturn(true);
        given(positions.checkForWinner()).willReturn(false, false, false, false, false, true);
        given(positions.areEmpty()).willReturn(true);

        game.start(gameType);

        verify(console).printWinner(humanPlayer1);
    }

    @Test public void
    announce_a_draw_if_a_draw() {
        createPlayers();

        game = new Game(allPlayers, positions, console, lines);

        given(gameType.isMultiPlayer()).willReturn(true);
        given(positions.checkForWinner()).willReturn(false, false, false, false, false, false, false, false, false, false);
        given(positions.areEmpty()).willReturn(false, false, false, false, false, false, false, false, false, true);

        game.start(gameType);

        verify(console).printDraw();
    }

    private void createPlayers() {
        allPlayers = new ArrayList();
        computerTurnGenerator = new ComputerTurnGenerator();
        Marker marker = new Nought();

        humanPlayer1 = new HumanPlayer(null, null);
        humanPlayer2 = new HumanPlayer(null, null);
        computerPlayer = new ComputerPlayer(computerTurnGenerator, marker);

        allPlayers.add(humanPlayer1);
        allPlayers.add(humanPlayer2);
        allPlayers.add(computerPlayer);
    }

    private void createMockPlayers() {
        allMockPlayers = new ArrayList();

        allMockPlayers.add(mockHumanPlayer1);
        allMockPlayers.add(mockHumanPlayer2);
        allMockPlayers.add(mockComputerPlayer);
    }
}
