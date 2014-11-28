package com.codurance;

import com.codurance.Cell.CellReference;
import com.codurance.Game.GameType;
import com.codurance.Players.Player;

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

    public CellReference requestNextMove(Player player) {
        System.out.println(player.getName() + " please enter your move");
        return new CellReference(scanner.nextLine());
    }

    public void printWinner(Player player) {
        System.out.println("-----------------------");
        System.out.println(player.getName() + " is the winner!");
        System.out.println("-----------------------\n");
    }

    public void printDraw() {
        System.out.println("-------------");
        System.out.println("It's a draw!");
        System.out.println("-------------\n");
    }

    public void computerMoveConfirmation() {
        System.out.println("Computer has made its move");
    }
}
