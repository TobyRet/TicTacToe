package com.codurance.Game;

import com.codurance.Board.Board;
import com.codurance.Console.Console;
import com.codurance.Players.BoardMarker;
import com.codurance.Players.HumanPlayer;
import com.codurance.Players.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameShould {

    private final String TWO_PLAYER_GAME = "T";
    private Game game;
    @Mock Board board;
    @Mock Console console;
    @Mock Players players;
    @Mock HumanPlayer mockPlayer1;
    @Mock HumanPlayer mockPlayer2;

    @Before
    public void initialise() {
        game = new Game(console, board, players);
        given(console.readLine()).willReturn(TWO_PLAYER_GAME);
    }

    @Test public void
    load_two_human_players_when_2_player_game_selected() {
        given(players.load(TWO_PLAYER_GAME)).willReturn(twoHumanPlayers());
        given(board.isThereAWinner()).willReturn(true);

        game.start();

        verify(console).printLine("Select game type");
        verify(players).load(TWO_PLAYER_GAME);

    }


    @Test public void
    announce_the_winner_if_player_has_won_the_game() {
        given(players.load(TWO_PLAYER_GAME)).willReturn(twoHumanPlayers());
        given(board.isThereAWinner()).willReturn(true);

        game.start();

        verify(console).printLine("Select game type");
        verify(console).printLine("O wins");
    }

    @Test public void
    let_players_submit_moves_if_there_is_no_winner() {
        given(players.load(TWO_PLAYER_GAME)).willReturn(twoHumanPlayers());
        given(board.isThereAWinner()).willReturn(false, false, true);

        game.start();



        verify(console).printLine("Select game type");
        verify(console).printLine("O wins");
    }

    private List<Player> twoHumanPlayers() {
        return new ArrayList<>(Arrays.asList(
                new HumanPlayer(BoardMarker.NOUGHT, console),
                new HumanPlayer(BoardMarker.CROSS, console)));
    }

    private List<Player> createTwoMockPLayers() {
        return new ArrayList<>(Arrays.asList(mockPlayer1, mockPlayer2));
    }
}
