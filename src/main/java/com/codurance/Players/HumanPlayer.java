package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Board.BoardMarker;
import com.codurance.Cell.CellReference;
import com.codurance.Console;

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
    public void makeMove(Board board, Console console) {
        CellReference cellReference = console.requestNextMove(this);
        board.addMove(cellReference, boardMarker);
    }
}
