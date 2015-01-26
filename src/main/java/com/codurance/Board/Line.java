package com.codurance.Board;

import java.util.List;

public class Line {
    private final int firstPosition;
    private final int secondPosition;
    private final int thirdPosition;

    public Line(int firstPosition, int secondPosition, int thirdPosition) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
    }

    public boolean doYouHaveWinner(List<Move> board) {
        return !lineContainsNullValues(board) && firstPositionEqualsSecondPosition(board) &&
                secondPositionEqualsThirdPosition(board);
    }

    private boolean firstPositionEqualsSecondPosition(List<Move> board) {
        return board.get(firstPosition).getBoardMarkerValue()
                .equals(board.get(secondPosition).getBoardMarkerValue());
    }

    private boolean secondPositionEqualsThirdPosition(List<Move> board) {
        return board.get(secondPosition).getBoardMarkerValue()
                .equals(board.get(thirdPosition).getBoardMarkerValue());
    }

    private boolean lineContainsNullValues(List<Move> board) {
        if(board.get(firstPosition).getBoardMarkerValue() == null
                || board.get(secondPosition).getBoardMarkerValue() == null
                || board.get(thirdPosition).getBoardMarkerValue() == null) {
            return true;
        }
        return false;
    }
}
