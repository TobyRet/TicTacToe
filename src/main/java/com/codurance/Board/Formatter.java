package com.codurance.Board;

import com.codurance.Console;

import java.util.List;

public class Formatter {

    private String formattedRow;

    public void print(Console console, List<String> positions) {
        String formattedPositions = formatFirstRow(positions) + formatSecondRow(positions) + formatThirdRow(positions);
        console.printPositions(formattedPositions);
    }

    private String formatThirdRow(List<String> positions) {
        formattedRow = "";

        for(int i=6; i < 9; i ++) {
            formattedRow += (positions.get(i) + " ");
        }
        return formattedRow + "\n";
    }

    private String formatSecondRow(List<String> positions) {
        formattedRow = "";

        for(int i=3; i < 6; i ++) {
            formattedRow += (positions.get(i) + " ");
        }
        return formattedRow + "\n";
    }

    private String formatFirstRow(List<String> positions) {
       formattedRow = "";

        for(int i=0; i < 3; i ++) {
            formattedRow += (positions.get(i) + " ");
        }
        return formattedRow + "\n";
    }
}
