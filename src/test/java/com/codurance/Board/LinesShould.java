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
    @Mock Position mockedPosition;
    @Mock Line mockedLine;

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

    private List<Line> createMockLines() {
        List<Line> mockLinesList = new ArrayList();

        for(int i=0; i<9; i++) {
            mockLinesList.add(mockedLine);
        }

        return mockLinesList;
    }

}
