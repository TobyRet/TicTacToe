package com.codurance.Game;

import com.codurance.Board.Board;
import com.codurance.Console.Console;
import com.codurance.Players.BoardMarker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameShould {

	public static final String SOME_BOARD_POSITION = "1";
	private static final String ANOTHER_BOARD_POSITION = "2";
	private static final String FORMATTED_EMPTY_BOARD = "_ _ _\n_ _ _\n_ _ _";
	private static final String FORMATTED_BOARD_WITH_ONE_POSITION = "O _ _\n_ _ _\n_ _ _";
	private Game game;
	@Mock Board board;
	@Mock Console console;

	@Before
	public void initialise() {
		game = new Game(console, board);
	}

	@Test public void
	print_board_to_console() {
		given(console.read()).willReturn(SOME_BOARD_POSITION);
		given(board.getBoardForPrinting()).willReturn(FORMATTED_EMPTY_BOARD);
		given(board.isThereAWinner()).willReturn(true);
		given(board.isThereADraw()).willReturn(false);

		game.start();

		verify(console).print("Welcome to Tic Tac Toe");
		verify(console).print("Please submit your move");
		verify(console).print(FORMATTED_EMPTY_BOARD);
	}

	@Test public void
	stop_play_if_there_is_winner_and_announce_winner() {
		given(console.read()).willReturn(SOME_BOARD_POSITION);
		given(board.getBoardForPrinting()).willReturn(FORMATTED_BOARD_WITH_ONE_POSITION);
		given(board.isThereAWinner()).willReturn(true);
		given(board.isThereADraw()).willReturn(false);

		game.start();

		verify(board, times(1)).addMove(BoardMarker.NOUGHT, SOME_BOARD_POSITION);
		verify(console).print(FORMATTED_BOARD_WITH_ONE_POSITION);
		verify(console).print("O wins");
	}

	@Test public void
	stop_play_if_there_is_a_draw_and_announce_draw() {
		given(console.read()).willReturn(SOME_BOARD_POSITION);
		given(board.isThereAWinner()).willReturn(false);
		given(board.isThereADraw()).willReturn(true);

		game.start();

		verify(console).print("Draw!");
	}

	@Test public void
	continue_play_whilst_there_is_not_a_winner() {
		given(console.read()).willReturn(SOME_BOARD_POSITION, ANOTHER_BOARD_POSITION);
		given(board.isThereAWinner()).willReturn(false, true);
		given(board.isThereADraw()).willReturn(false);

		game.start();

		verify(console, times(2)).print("Please submit your move");
		verify(board, times(1)).addMove(BoardMarker.NOUGHT, SOME_BOARD_POSITION);
		verify(board, times(1)).addMove(BoardMarker.CROSS, ANOTHER_BOARD_POSITION);
		verify(console).print("X wins");
	}
}
