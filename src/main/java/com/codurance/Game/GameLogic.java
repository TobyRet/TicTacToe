package com.codurance.Game;

import com.codurance.Board.Board;

public class GameLogic {
    private final Board board;
    private final WinningCombinations winningCombinations;
    private boolean winState = false;

    public GameLogic(Board board, WinningCombinations winningCombinations) {
        this.board = board;
        this.winningCombinations = winningCombinations;
    }

    public boolean checkForWin() {
        for(WinningCombination winningCombination : winningCombinations.getCombinations()) {
            String firstCell = board.getCells().get(winningCombination.getCell1()).getValue();
            String secondCell = board.getCells().get(winningCombination.getCell2()).getValue();
            String thirdCell = board.getCells().get(winningCombination.getCell3()).getValue();

            if(isNotAnEmptyValue(firstCell) && firstCell.equals(secondCell) && secondCell.equals(thirdCell)) {
                winStateAchieved(true);
            }
        }
        return winState;
    }

    private void winStateAchieved(boolean newWinState) {
        winState = newWinState;
    }

    private boolean isNotAnEmptyValue(String value) {
        return (value.equals("X") || value.equals("O"));
    }
}
