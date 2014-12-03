package com.codurance.Console;

import com.codurance.Console.Console;

import java.util.List;

public class Formatter {

    private String formattedRow;

    public void print(Console console, List<String> positions) {
        String formattedPositions = formatRow(0, 3, positions) + formatRow(3, 6, positions) + formatRow(6, 9, positions);
        console.printPositions(formattedPositions);
    }

    private String formatRow(int rowStart, int rowEnd, List<String> positions) {
        formattedRow = "";

        for(int i=rowStart; i < rowEnd; i ++) {
            formattedRow += (positions.get(i) + " ");
        }
        return formattedRow + "\n";
    }
}
