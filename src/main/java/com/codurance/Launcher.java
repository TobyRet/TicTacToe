package com.codurance;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        Console console = new Console();

        TicTacToe ticTacToe = new TicTacToe(console);
        ticTacToe.loadGameType();
    }
}
