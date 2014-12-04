package com.codurance.Board;

import com.codurance.Console.Formatter;
import org.junit.Before;
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
    private Lines lines;
    private Formatter formatter;
    private List<String> positions;
    @Mock Position mockedPosition1;
    @Mock Position mockedPosition2;
    @Mock Line mockedLine;
    @Mock Positions mockedPositions;

    @Before
    public void initialise() {
        formatter = new Formatter();
        positions = new Positions(formatter, lines).getAll();
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

    @Test public void
    return_a_position_that_completes_a_lines_for_the_win() {
        given(mockedLine.completeARow(mockedPositions)).willReturn(mockedPosition1, mockedPosition2);
        assertThat(lines.completeForWin(mockedPositions), is(mockedPosition1));
    }

    private List<Line> createMockLines() {
        List<Line> mockLinesList = new ArrayList();

        for(int i=0; i<9; i++) {
            mockLinesList.add(mockedLine);
        }

        return mockLinesList;
    }

}
