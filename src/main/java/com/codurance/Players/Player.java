package com.codurance.Players;

import com.codurance.Console.Console;
import com.codurance.Board.Board;

public interface Player {

    void makeMove(Board board, Console console);

    void setName(String name);

    String getName();

    String getMarker();
}
