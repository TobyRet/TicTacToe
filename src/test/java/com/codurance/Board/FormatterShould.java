package com.codurance.Board;

import com.codurance.Players.BoardMarker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FormatterShould {

	private static final String A_FORMATTED_FULL_BOARD = "X X X \nX X X \nX X X \n";
	private static final String A_FORMATTED_EMPTY_BOARD = "_ _ _ \n_ _ _ \n_ _ _ \n";
	private Formatter formatter;
	private List<Move> board = new ArrayList();

	@Before
	public void initialise() {
		formatter = new Formatter();
	}

	@Test public void
	format_an_empty_board_for_printing() {
		assertThat(formatter.format(createEmpty(board)), is(A_FORMATTED_EMPTY_BOARD));
	}

	@Test public void
	format_a_full_board_for_printing() {
		assertThat(formatter.format(createFull(board)), is(A_FORMATTED_FULL_BOARD));
	}

	private List<Move> createFull(List<Move> board) {
		createEmpty(board);

		for(Move move : board) {
			move.setBoardMarkerValue(BoardMarker.CROSS);
		}

		return board;
	}

	private List<Move> createEmpty(List<Move> board) {
		board.add(new Move());
		board.add(new Move());
		board.add(new Move());
		board.add(new Move());
		board.add(new Move());
		board.add(new Move());
		board.add(new Move());
		board.add(new Move());
		board.add(new Move());

		return board;
	}


}
