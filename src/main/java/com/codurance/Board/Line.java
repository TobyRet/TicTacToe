package com.codurance.Board;

import java.util.ArrayList;
import java.util.List;

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

    public Position completeARow(Positions positions) {
        return null;
    }
}
