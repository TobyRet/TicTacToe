package com.codurance;

import java.util.Scanner;

public class Console {

    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public GameType requestGameType() {
        System.out.println("" +
                "TIC TAC TOE\n" +
                "-----------\n\n" +
                "Please select [M]ultiplayer game or [S]ingleplayer game");

        return new GameType(scanner.nextLine());
    }

    public void printBoard(String board) {
        System.out.println(board);
    }

    public String requestNextMove(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + "'s turn\n");
        System.out.print(">> ");
        return scanner.nextLine();
    }

    public void printWinner(Player player) {
        System.out.println("\n-----------------------");
        System.out.println(player.getName() + " is the winner!");
        System.out.println("-----------------------");

    }
}
