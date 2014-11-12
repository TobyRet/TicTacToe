package com.codurance.Game;

import com.codurance.Board.Board;

public class GameLogic {
    private final Board board;
    private boolean winState = false;
    private final int[][] winningCellCombinations = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public GameLogic(Board board) {
        this.board = board;
    }

    public boolean checkForWin() {
        for(int[] winningCellCombination : winningCellCombinations) {
            if(cellValue1EqualsCellValue2(winningCellCombination) && cellValue2EqualsCellValue3(winningCellCombination)){
                winState = true;
            }
        }
        return winState;
    }

    private boolean cellValue1EqualsCellValue2(int[] winningPattern) {
        return cellValue(winningPattern[0]).equals(cellValue(winningPattern[1])) && isNotAnEmptyValue(winningPattern[0]);
    }

    private boolean cellValue2EqualsCellValue3(int[] winningPattern) {
        return cellValue(winningPattern[1]).equals(cellValue(winningPattern[2])) && isNotAnEmptyValue(winningPattern[0]);
    }

    private String cellValue(int index) {
        return board.getCells().get(index).getValue();
    }

    private boolean isNotAnEmptyValue(int index) {
        return (cellValue(index).equals("X") || cellValue(index).equals("O"));
    }
}
