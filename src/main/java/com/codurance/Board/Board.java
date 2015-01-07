package com.codurance.Board;

import com.codurance.Players.BoardMarker;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Lines lines;
    private List<Move> boardPositions;

    public Board(Lines lines) {
        this.lines = lines;
        initialiseEmptyBoard();

    }

    private void initialiseEmptyBoard() {
        boardPositions = new ArrayList();
        for(int i=0; i<9; i++) {
            boardPositions.add(new Move());
        }
    }

    public boolean isThereAWinner() {
        return lines.checkForWin(this);
    }

    public void addMove(BoardMarker boardMarker, String boardPosition) {
        int boardPositionAsIndexValue = Integer.parseInt(boardPosition) - 1;
        boardPositions.get(boardPositionAsIndexValue).setValue(boardMarker);
    }

    public boolean isEmpty() {
        boolean boardIsEmpty = true;
        for(Move move : boardPositions) {
            if(!(move.getValue() == null)) {
                boardIsEmpty = false;
            }
        }
        return boardIsEmpty;
    }

    public boolean isFull() {
        boolean boardIsFull = true;
        for(Move move : boardPositions) {
            if((move.getValue() == null)) {
                boardIsFull = false;
            }
        }
        return boardIsFull;
    }
}
