package com.codurance.Console;

import com.codurance.Board.Move;

import java.util.ArrayList;
import java.util.List;

public class Formatter {

    private String formattedRow;

	public String format(List<Move> board) {
        List<String> boardWithNullValuesConvertedToSpaces = convertNullValues(board);
		return formatRow(0, 3, boardWithNullValuesConvertedToSpaces)
                + formatRow(3, 6, boardWithNullValuesConvertedToSpaces)
                + formatRow(6, 9, boardWithNullValuesConvertedToSpaces);
	}

    private List<String> convertNullValues(List<Move> board) {
        List<String> nullValuesRemoved = new ArrayList();

        for(Move move : board) {
            if(move.getBoardMarkerValue() == null) {
                nullValuesRemoved.add("_");
            } else {
                nullValuesRemoved.add(move.getBoardMarkerValue());
            }
        }
        return nullValuesRemoved;
    }

    private String formatRow(int rowStart, int rowEnd, List<String> positions) {
        formattedRow = "";

        for(int i=rowStart; i < rowEnd; i ++) {
            formattedRow += (positions.get(i) + " ");
        }
        return formattedRow + "\n";
    }
}
