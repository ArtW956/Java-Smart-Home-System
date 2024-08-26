package com.company;

import java.util.Scanner;

public class ConsoleHelper {
    private int lastIntInput;

    public int intInput() {
        Scanner input = new Scanner(System.in);
        lastIntInput = input.nextInt();
        return lastIntInput;
    }

    public int returnLastIntInput() {
        return lastIntInput;
    }

    public String strInput() {
        Scanner input = new Scanner (System.in);
        return input.nextLine();
    }

    public void printStr(String prompt) {
        System.out.print(prompt);
    }
}
