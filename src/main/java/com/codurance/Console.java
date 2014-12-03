package com.codurance;

import com.codurance.Game.GameType;
import com.codurance.Players.Player;
import com.codurance.Positions.Position;

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

    public Position requestNextMove(Player player) {
        System.out.println(player.getName() + " please enter your move");
        int position = Integer.parseInt(scanner.nextLine()) - 1;
        return new Position(position);
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

    public void printPositions(String formattedPositions) {
        System.out.println(formattedPositions);
    }
}
