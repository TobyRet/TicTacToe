package com.codurance.Board;

import com.codurance.Players.BoardMarker;

public class Move {
    private String boardMarkerValue;

    public String getBoardMarkerValue() {
        return boardMarkerValue;
    }

    public void setBoardMarkerValue(BoardMarker boardMarker) {
        this.boardMarkerValue = boardMarker.value();
    }
}
