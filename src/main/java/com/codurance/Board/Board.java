package com.codurance.Board;

import com.codurance.Players.BoardMarker;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final LinesChecker linesChecker;
    private List<Move> boardPositions;

    public Board(LinesChecker linesChecker) {
        this.linesChecker = linesChecker;
        initialiseEmptyBoard();
    }

    public List<Move> getBoard() {
        return boardPositions;
    }

    public boolean isThereAWinner() {
        return linesChecker.checkForWin(getBoard());
    }

    public void addMove(BoardMarker boardMarker, String boardPosition) {
        int boardPositionAsIndexValue = Integer.parseInt(boardPosition) - 1;
        boardPositions.get(boardPositionAsIndexValue).setBoardMarkerValue(boardMarker);
    }

    public boolean isEmpty() {
        boolean boardIsEmpty = true;
        for(Move move : boardPositions) {
            if(!(move.getBoardMarkerValue() == null)) {
                boardIsEmpty = false;
            }
        }
        return boardIsEmpty;
    }

    public boolean isFull() {
        boolean boardIsFull = true;
        for(Move move : boardPositions) {
            if((move.getBoardMarkerValue() == null)) {
                boardIsFull = false;
            }
        }
        return boardIsFull;
    }

    private void initialiseEmptyBoard() {
        boardPositions = new ArrayList();
        for(int i=0; i<9; i++) {
            boardPositions.add(new Move());
        }
    }

    public String getBoardForPrinting() {
        return null;
    }

    public boolean isThereADraw() {
        return false;
    }
}
