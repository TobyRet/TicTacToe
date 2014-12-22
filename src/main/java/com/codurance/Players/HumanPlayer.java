package com.codurance.Players;

import com.codurance.Console.Console;
import com.codurance.Board.Board;
import com.codurance.Board.Position;

public class HumanPlayer implements Player {

    private final BoardMarker boardMarker;
    private String name;

    public HumanPlayer(BoardMarker boardMarker) {
        this.boardMarker = boardMarker;
    }

    @Override
    public void makeMove(Board board, Console console) {
        Position position = console.requestNextMove(this);
        board.addMove(boardMarker, position);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMarker() {
        return boardMarker.getMarker();
    }
}
