package com.codurance.Players;

import com.codurance.Board.BoardMarker;
import com.codurance.Cell.Position;
import com.codurance.Console;
import com.codurance.Game.Positions;

public class HumanPlayer implements Player {

    private final PlayerName playerName;
    private final BoardMarker boardMarker;

    public HumanPlayer(PlayerName playerName, BoardMarker boardMarker) {
        this.playerName = playerName;
        this.boardMarker = boardMarker;
    }

    @Override
    public String getName() {
        return playerName.getValue();
    }

    @Override
    public void makeMove(Positions positions, Console console) {
        Position move = console.requestNextMove(this);
        positions.addMove(move);
    }
}
