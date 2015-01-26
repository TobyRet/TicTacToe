package com.codurance.Console;

import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);

    public String read() {
        return scanner.nextLine();
    }

    public void print(String instruction) {
        System.out.println(instruction);
    }
}
