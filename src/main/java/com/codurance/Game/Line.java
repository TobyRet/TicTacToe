package com.codurance.Game;

public class Line {
    private final int firstCellIndex;
    private final int secondCellIndex;
    private final int thirdCellIndex;
    private int cellLocation;

    public Line(int cell1, int cell2, int cell3) {
        this.firstCellIndex = cell1;
        this.secondCellIndex = cell2;
        this.thirdCellIndex = cell3;
    }

    public boolean doYouHaveWinner() {
        return false;
    }

//    public boolean cellsHaveSameValues(List<Cell> boardCells) {
//        return firstCellIsNotNull(boardCells) && firstCellEqualsSecondCell(boardCells) && secondCellEqualsThirdCell(boardCells);
//    }
//
//    public Position identifyWinScenarioCellPosition(List<Cell> boardCells) {
//        List<String> compareValues = new ArrayList<>();
//
//        compareValues.add(boardCells.get(firstCellIndex).value());
//        compareValues.add(boardCells.get(secondCellIndex).value());
//        compareValues.add(boardCells.get(thirdCellIndex).value());
//
//        if(Collections.frequency(compareValues, "X") == 2 && Collections.frequency(compareValues, "-") == 1) {
//            cellLocation = compareValues.indexOf("-");
//            return new Position(String.valueOf(cellLocation));
//        } else {
//            return null;
//        }
//    }
//
//    private boolean firstCellIsNotNull(List<Cell> boardCells) {
//        return boardCells.get(firstCellIndex).value() != "-";
//    }
//
//    private boolean secondCellEqualsThirdCell(List<Cell> boardCells) {
//        return boardCells.get(secondCellIndex).value() == boardCells.get(thirdCellIndex).value();
//    }
//
//    private boolean firstCellEqualsSecondCell(List<Cell> boardCells) {
//        return boardCells.get(firstCellIndex).value() == boardCells.get(secondCellIndex).value();
//    }
}
