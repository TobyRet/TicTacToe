package com.codurance.ComputerStrategies;

import com.codurance.Board.Lines;
import com.codurance.Board.Position;
import com.codurance.Board.Board;
import com.codurance.Players.BoardMarker;

public class WinStrategy implements ComputerPlayerStrategy {

    private final Lines lines;

    public WinStrategy(Lines lines) {
        this.lines = lines;
    }

    @Override
    public void execute(BoardMarker boardMarker, Board board) {
        Integer positionIndex = getWinningPosition(boardMarker, board);
        board.addMove(boardMarker, new Position(positionIndex));
    }

    private Integer getWinningPosition(BoardMarker boardMarker, Board board) {
        return lines.completeForWin(board, boardMarker);
    }

    @Override
    public boolean isFeasible(BoardMarker marker, Board board) {
        return lines.completeForWin(board, marker) != null;
    }
}
