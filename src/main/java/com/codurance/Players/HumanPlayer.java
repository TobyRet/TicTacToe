package com.codurance.Players;

import com.codurance.Board.Board;
import com.codurance.Console.Console;

public class HumanPlayer implements Player {

    private final BoardMarker boardMarker;
    private String name;
    private Console console;

    public HumanPlayer(BoardMarker boardMarker, Console console) {
        this.boardMarker = boardMarker;
        this.console = console;
    }

    @Override
    public void addMoveTo(Board board) {
        board.addMove(boardMarker, console.readLine());
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BoardMarker getMarker() {
        return boardMarker;
    }
}
