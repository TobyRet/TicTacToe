package com.codurance.Board;

import com.codurance.Players.BoardMarker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LineShould {

    private Line line;
    private List<Move> board = new ArrayList<>();
    private Move crossMove = new Move();
    private Move nullMove = new Move();

    @Before
    public void initialise() {
        crossMove.setBoardMarkerValue(BoardMarker.CROSS);
    }

    @Test
    public void
    return_true_if_board_contains_three_consecutive_noughts_or_crosses() {
        line = new Line(0,1,2);

        assertThat(line.doYouHaveWinner(boardWithRowWinner()), is(true));
    }

    @Test public void
    return_false_if_board_does_not_contain_three_consecutive_noughts_crosses() {
        line = new Line(0,1,2);

        assertThat(line.doYouHaveWinner(boardWithNoRowWinner()), is(false));
    }

    @Test public void
    return_false_if_board_contains_three_consecuitve_null_values() {
        line = new Line(0,4,8);

        assertThat(line.doYouHaveWinner(boardWithAllNullValues()), is(false));
    }

    private List<Move> boardWithAllNullValues() {
        for(int i=0; i<8; i++) {
            board.add(nullMove);
        }

        return board;
    }

    private List<Move> boardWithRowWinner() {
        for(int i=0; i<3; i++) {
            board.add(crossMove);
        }

        for(int i=0; i<6; i++) {
            board.add(nullMove);
        }

        return board;
    }

    private List<Move> boardWithNoRowWinner() {
        for(int i=0; i<2; i++) {
            board.add(crossMove);
        }

        for(int i=0; i<7; i++) {
            board.add(nullMove);
        }

        return board;
    }
}
