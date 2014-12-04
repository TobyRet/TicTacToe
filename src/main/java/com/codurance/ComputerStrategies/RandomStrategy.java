package com.codurance.ComputerStrategies;


import com.codurance.Board.Marker;
import com.codurance.Board.Position;
import com.codurance.Board.Positions;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomStrategy implements ComputerPlayerStrategy {

    private static final String EMPTY = "-";
    private Random randomGenerator;

    public RandomStrategy(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public void execute(Marker marker, Positions positions) {
        positions.addMove(marker, generateRandomPosition(positions));
    }

    @Override
    public boolean isFeasible(Marker marker, Positions positions) {
        return false;
    }

    private Position generateRandomPosition(Positions positions) {

        List<Integer> indexes = positions.getAll().stream().filter(position -> position.equals(EMPTY))
                                                            .map(position -> positions.getAll().indexOf(position))
                                                            .collect(Collectors.toList());

        int randomIndex = randomGenerator.nextInt(indexes.size());

        return new Position(randomIndex);
    }
}
