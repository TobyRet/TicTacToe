package com.codurance.Board;

import com.codurance.Console.Formatter;
import com.codurance.Players.BoardMarker;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class LinesShould {
    private static final Integer FIRST_VALUE = 0;
    private static final Integer SECOND_VALUE = 1;
    private Lines lines;
    private Formatter formatter;
    private List<String> positions;
    @Mock Position mockedPosition1;
    @Mock Position mockedPosition2;
    @Mock Line mockedLine;
    @Mock
    Board mockedBoard;

    @Before
    public void initialise() {
        formatter = new Formatter();
        positions = new Board(formatter, lines).getAll();
        lines = new Lines(createMockLines());
    }

    @Test public void
    declare_there_is_no_winner_if_no_line_contains_three_in_row() {
        given(mockedLine.doYouHaveWinner(positions)).willReturn(false);
        assertThat(lines.checkLinesForWinner(positions), is(false));
    }

    @Test public void
    declare_there_is_a_winner_if_line_contains_three_in_a_row() {
        given(mockedLine.doYouHaveWinner(positions)).willReturn(true, false, false, false, false, false, false, false, false);
        assertThat(lines.checkLinesForWinner(positions), is(true));
    }

    @Ignore
    @Test public void
    return_a_position_that_completes_a_lines_for_the_win() {
        given(mockedLine.completeARow(createValues(), BoardMarker.CROSS)).willReturn(FIRST_VALUE, SECOND_VALUE);
        assertThat(lines.completeForWin(mockedBoard, BoardMarker.CROSS), is(0));
    }

    private List<String> createValues() {
        List<String> values = new ArrayList<>();
        for(int i=0; i<9; i++) {
            values.add("-");
        }
        return values;
    }

    private List<Line> createMockLines() {
        List<Line> mockLinesList = new ArrayList();

        for(int i=0; i<9; i++) {
            mockLinesList.add(mockedLine);
        }

        return mockLinesList;
    }

}
