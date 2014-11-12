package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Console;

public interface Player {
    String getName();

    void makeMove(Board board, Console console);
}
