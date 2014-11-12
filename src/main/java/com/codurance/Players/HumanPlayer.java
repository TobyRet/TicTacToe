package com.codurance.Players;

import com.codurance.*;
import com.codurance.Board.Board;
import com.codurance.Cell.CellReference;

public class HumanPlayer implements Player {

    private final Board board;
    private final Console console;
    private final PlayerName playerName;

    public HumanPlayer(PlayerName playerName, Board board, Console console) {
        this.playerName = playerName;
        this.board = board;
        this.console = console;
    }

    @Override
    public String getName() {
        return playerName.getValue();
    }

    @Override
    public void makeMove() {
        CellReference cellReference = console.requestNextMove(this);
        board.addMove(cellReference);
    }
}
