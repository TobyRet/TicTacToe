//package com.codurance.ComputerStrategies;
//
//
//import com.codurance.Board.Position;
//import com.codurance.Board.Board;
//import com.codurance.Players.BoardMarker;
//
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Collectors;
//
//public class RandomStrategy implements ComputerPlayerStrategy {
//
//    private static final String EMPTY = "-";
//    private Random randomGenerator;
//
//    public RandomStrategy(Random randomGenerator) {
//        this.randomGenerator = randomGenerator;
//    }
//
//    @Override
//    public void execute(BoardMarker boardMarker, Board board) {
//        board.addMove(boardMarker, generateRandomPosition(board));
//    }
//
//    @Override
//    public boolean isFeasible(BoardMarker marker, Board board) {
//        return false;
//    }
//
//    private Position generateRandomPosition(Board board) {
//
//        List<Integer> indexes = board.getAll().stream().filter(position -> position.equals(EMPTY))
//                                                            .map(position -> board.getAll().indexOf(position))
//                                                            .collect(Collectors.toList());
//
//        int randomIndex = randomGenerator.nextInt(indexes.size());
//
//        return new Position(randomIndex);
//    }
//}
