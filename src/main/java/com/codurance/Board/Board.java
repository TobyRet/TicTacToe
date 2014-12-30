package com.codurance.Board;

import com.codurance.Players.BoardMarker;

public class Board {

    private final Lines lines;

    public Board(Lines lines) {
        this.lines = lines;
    }

    public boolean isThereAWinner() {
        return lines.checkForWin(this);
    }


    public void addMove(BoardMarker boardMarker, String boardPosition) {

    }
}
