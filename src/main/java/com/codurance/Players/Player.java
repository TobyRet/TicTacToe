package com.codurance.Players;

import com.codurance.Console;
import com.codurance.Game.Positions;
import com.codurance.Positions.Marker;

public interface Player {

    void makeMove(Positions board, Console console);

    String getName();

    Marker getMarker();
}
