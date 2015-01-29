package com.codurance;

import com.codurance.Board.Board;
import com.codurance.Board.Lines;
import com.codurance.Board.LinesChecker;
import com.codurance.Console.Console;
import com.codurance.Console.Formatter;
import com.codurance.Game.Game;

public class Launcher {

	public static void main(String[] args) {
		LinesChecker linesChecker = new LinesChecker(Lines.create());
		Formatter formatter = new Formatter();
		Console console = new Console();
		Board board = new Board(linesChecker, formatter);
		Game game = new Game(console, board);
		game.start();
	}
}

