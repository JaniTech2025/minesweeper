package main;
import util.*;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Grid mineGrid = new Grid();
        mineGrid.generateGrid(10, 10);
        mineGrid.revealGrid();
        Scanner scan = new Scanner(System.in);


        while(true) {
            System.out.println("Enter row and column in format eg.5 5 to reveal a cell, Or X to exit game");
            String input = scan.nextLine().trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("You chose to quit.");
                System.exit(0);
            }
            String[] numbers = input.split("\\s+");
            if(numbers.length != 2) {
                System.out.println("You entered an invalid number");
                continue;
            }
            try {
                int row = Integer.parseInt(numbers[0]);
                int col = Integer.parseInt(numbers[1]);
                mineGrid.revealCell(row, col);
                mineGrid.revealGrid();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers.");
            }
        }

    }
}
