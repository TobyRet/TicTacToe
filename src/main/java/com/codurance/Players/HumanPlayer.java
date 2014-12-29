package com.codurance.Players;

import com.codurance.Board.Board;

public class HumanPlayer implements Player {

    private final BoardMarker boardMarker;
    private String name;

    public HumanPlayer(BoardMarker boardMarker) {
        this.boardMarker = boardMarker;
    }

    @Override
    public void addMoveTo(Board board) {
//        Position position = console.requestNextMove(this);
//        board.addMove(boardMarker, position);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getMarker() {
        return boardMarker.getMarker();
    }
}
