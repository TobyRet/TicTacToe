package com.codurance.ComputerStrategies;

import com.codurance.Board.Marker;
import com.codurance.Board.Positions;

public interface ComputerPlayerStrategy {
    void execute(Marker marker, Positions positions);
}
