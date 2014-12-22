package com.codurance.ComputerStrategies;

import com.codurance.Board.Board;
import com.codurance.Players.BoardMarker;

public interface ComputerPlayerStrategy {
    void execute(BoardMarker boardMarker, Board board);

    boolean isFeasible(BoardMarker marker, Board board);
}
