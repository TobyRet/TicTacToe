package com.codurance.Players;

import com.codurance.Board.Board;

public interface Player {

    void addMoveTo(Board board);

    BoardMarker boardMarker();
}
