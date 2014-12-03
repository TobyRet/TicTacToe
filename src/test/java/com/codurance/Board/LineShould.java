package com.codurance.Board;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LineShould {

    private static final String EMPTY = "-";
    private static final String CROSS = "X";
    private Line line;
    private List<String> positions;

    @Test
    public void
    return_true_if_a_row_has_equal_values() {
        line = new Line(0,1,2);
        positions = rowWin();

        assertThat(line.doYouHaveWinner(positions), is(true));
    }

    @Test public void
    return_false_if_row_does_not_have_equal_values() {
        line = new Line(0,1,2);
        positions = rowNoWin();

        assertThat(line.doYouHaveWinner(positions), is(false));
    }

    @Test
    public void
    return_true_if_a_column_has_equal_values() {
        line = new Line(0,3,6);
        positions = columnWin();

        assertThat(line.doYouHaveWinner(positions), is(true));
    }

    @Test public void
    return_false_if_column_does_not_have_equal_values() {
        line = new Line(0,3,6);
        positions = rowWin();

        assertThat(line.doYouHaveWinner(positions), is(false));
    }

    @Test
    public void
    return_true_if_a_diagonal_has_equal_values() {
        line = new Line(0,4,8);
        positions = diagonalWin();

        assertThat(line.doYouHaveWinner(positions), is(true));
    }

    @Test public void
    return_false_if_diagonal_does_not_have_equal_values() {
        line = new Line(0,3,6);
        positions = rowWin();

        assertThat(line.doYouHaveWinner(positions), is(false));
    }

    // Code smell. Fix below. Builder pattern?

    private List<String> rowNoWin() {
        positions = new ArrayList<>();

        positions.add(CROSS);
        positions.add(CROSS);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);

        return positions;
    }

    private List<String> columnWin() {
        positions = new ArrayList<>();

        positions.add(CROSS);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(CROSS);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(CROSS);
        positions.add(EMPTY);
        positions.add(EMPTY);

        return positions;
    }

    private List<String> rowWin() {
        positions = new ArrayList<>();

        positions.add(CROSS);
        positions.add(CROSS);
        positions.add(CROSS);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);

        return positions;
    }

    private List<String> diagonalWin() {
        positions = new ArrayList<>();

        positions.add(CROSS);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(CROSS);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(EMPTY);
        positions.add(CROSS);

        return positions;
    }
}
