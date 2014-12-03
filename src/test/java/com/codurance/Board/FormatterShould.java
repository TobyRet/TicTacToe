package com.codurance.Board;

import com.codurance.Console;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FormatterShould {

    private static final String EMPTY_POSITION = "-";
    private String EMPTY_BOARD = "- - - \n- - - \n- - - \n";

    @Test public void
    print_formatted_positions_to_console() {
        Console console = mock(Console.class);
        Formatter formatter = new Formatter();
        formatter.print(console, createPositions());
        verify(console).printPositions(EMPTY_BOARD);
    }

    private List<String> createPositions() {
        List<String> positions = new ArrayList<>(9);
        for(int i=0; i < 9; i++) {
            positions.add(EMPTY_POSITION);
        }
        return positions;
    }
}
