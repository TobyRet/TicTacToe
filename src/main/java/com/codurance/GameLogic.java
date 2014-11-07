package com.codurance;

public class GameLogic {
    private final Board board;
    private boolean winState;
    private final int[][] winningCombinations = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public GameLogic(Board board) {
        this.board = board;
    }

    public boolean checkForWin() {
        for(int[] winningCombination : winningCombinations) {
            if(cellValue1EqualsCellValue2(winningCombination) && cellValue2EqualsCellValue3(winningCombination)){
                winState = true;
            }
        }
        return winState;
    }

    private boolean cellValue1EqualsCellValue2(int[] winningPattern) {
        return cellValue(winningPattern[0]).equals(cellValue(winningPattern[1]));
    }

    private boolean cellValue2EqualsCellValue3(int[] winningPattern) {
        return cellValue(winningPattern[1]).equals(cellValue(winningPattern[2]));
    }

    private String cellValue(int index) {
        return board.getCells().get(index).getValue();
    }
}
