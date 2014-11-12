package com.codurance.Game;

import java.util.ArrayList;
import java.util.List;

public class WinningCombinations {

    private List<WinningCombination> combinations = new ArrayList();

    public WinningCombinations() {
        createCombinations();
    }

    private void createCombinations() {
        WinningCombination row1 = new WinningCombination(0,1,2);
        WinningCombination row2 = new WinningCombination(3,4,5);
        WinningCombination row3 = new WinningCombination(6,7,8);
        WinningCombination column1 = new WinningCombination(0,3,6);
        WinningCombination column2 = new WinningCombination(1,4,7);
        WinningCombination column3 = new WinningCombination(2,5,8);
        WinningCombination diagonal1 = new WinningCombination(0,4,8);
        WinningCombination diagonal2 = new WinningCombination(2,4,6);

        combinations.add(row1);
        combinations.add(row2);
        combinations.add(row3);
        combinations.add(column1);
        combinations.add(column2);
        combinations.add(column3);
        combinations.add(diagonal1);
        combinations.add(diagonal2);
    }

    public List<WinningCombination> getCombinations() {
        return combinations;
    }
}
