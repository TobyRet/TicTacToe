package com.codurance.Players;

import com.codurance.Console.Console;
import com.codurance.Board.Positions;
import com.codurance.Board.Marker;

public interface Player {

    void makeMove(Positions positions, Console console);

    String getName();

    Marker getMarker();
}
