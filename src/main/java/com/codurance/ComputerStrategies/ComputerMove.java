/*package com.codurance.ComputerStrategies;

import com.codurance.Board.Board;
import com.codurance.Positions.Position;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerMove {
    private final List<ComputerPlayerStrategy> computerStrategyList;
    private Board board;

    public ComputerMove(List<ComputerPlayerStrategy> computerStrategyList, Board board) {
        this.computerStrategyList = computerStrategyList;
        this.board = board;
    }

    public Position calculateNextMove() {
        List<Position> possibleMoves = computerStrategyList.stream().map(strategy -> strategy.execute(board.getCells())).collect(Collectors.toList());
        System.out.println(possibleMoves);
        possibleMoves.removeAll(Collections.singleton(null));
        return possibleMoves.get(0);
    }
}*/
