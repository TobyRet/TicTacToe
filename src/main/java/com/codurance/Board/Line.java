package com.codurance.Board;

import com.codurance.Players.BoardMarker;

import java.util.*;
import java.util.stream.Collectors;

public class Line {
    private final int firstPositionIndex;
    private final int secondPositionIndex;
    private final int thirdPositionIndex;
    private List<String> lineValues;

    public Line(int cell1, int cell2, int cell3) {
        this.firstPositionIndex = cell1;
        this.secondPositionIndex = cell2;
        this.thirdPositionIndex = cell3;
    }

    public boolean doYouHaveWinner(List<String> positions) {
        lineValues = getLineValues(positions);

        return lineHasNoEmptyPositions() && lineHasEqualValues();
    }

    private List<String> getLineValues(List<String> positions) {
        List<String> lineValues = new ArrayList<>();

        lineValues.add(positions.get(firstPositionIndex));
        lineValues.add(positions.get(secondPositionIndex));
        lineValues.add(positions.get(thirdPositionIndex));
        return lineValues;
    }

    private boolean lineHasEqualValues() {
        return lineValues.get(0).equals(lineValues.get(1)) && lineValues.get(1).equals(lineValues.get(2));
    }

    private boolean lineHasNoEmptyPositions() {
        return !lineValues.contains("-");
    }

    public Integer completeARow(List<String> positions, BoardMarker marker) {
        List<String> lineValues = getLineValues(positions);
        List<String> emptyValues = getEmptyPositions(lineValues);
        List<String> computerMoves = getComputerMovesInLine(marker, lineValues);

        System.out.println();
        System.out.println(lineValues);

        if(emptyValues.size() == 1 && computerMoves.size() == 2) {
            return lineValues.indexOf("-");
        } else {
            return null;
        }
    }

    private List<String> getComputerMovesInLine(BoardMarker boardMarker, List<String> lineValues) {
        List<String> computerMoves = new ArrayList<>();
        computerMoves.addAll(lineValues.stream().filter(value -> value.equals(boardMarker.value())).collect(Collectors.toList()));
        return computerMoves;
    }

    private List<String> getEmptyPositions(List<String> lineValues) {
        List<String> emptyValues = new ArrayList<>();
        emptyValues.addAll(lineValues.stream().filter(value -> value.equals("-")).collect(Collectors.toList()));
        return emptyValues;
    }
}
