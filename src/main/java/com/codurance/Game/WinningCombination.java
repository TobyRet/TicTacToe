package com.codurance.Game;

public class WinningCombination {
    private final int cell1;
    private final int cell2;
    private final int cell3;

    public WinningCombination(int cell1, int cell2, int cell3) {
        this.cell1 = cell1;
        this.cell2 = cell2;
        this.cell3 = cell3;
    }

    public int getCell1() {
        return cell1;
    }

    public int getCell2() {
        return cell2;
    }

    public int getCell3() {
        return cell3;
    }
}
