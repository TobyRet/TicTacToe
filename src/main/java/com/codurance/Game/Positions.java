package com.codurance.Game;

import com.codurance.Cell.Position;

import java.util.ArrayList;
import java.util.List;

public class Positions {

    public List<Position> positionsList = new ArrayList(9);

    public boolean areEmpty() {
        return positionsList.size() <= 9;
    }

    public void addMove(Position position) {
        positionsList.add(position);
    }

}
