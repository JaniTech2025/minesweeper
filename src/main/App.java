package main;
import util.*;

import java.util.*;

import static util.MyUtils.*;


public class App {
    public static void main(String[] args) {
        Grid mineGrid = new Grid();
        int size = 10;
        mineGrid.generateGrid(size, size);
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

                if (bombUncovered(mineGrid.getGrid(), row, col)) {
                    System.out.println("******************");
                    System.out.println("****Game lost ******");
                    System.out.println("******************");
                    System.exit(0);
                } else if (gameWin(mineGrid.getGrid())) { //Check current state of Grid is win state
                    System.out.println("******************");
                    System.out.println("****Game won******");
                    System.out.println("******************");
                    System.exit(0);
                } else {
                    System.out.println("Hint: ;)");
                    ArrayList<String> result = getBombsAround(mineGrid.getGrid(), row, col);
                    if (result.isEmpty()) {
                        System.out.println("No hint showing? Try another cell coordinates");
                    }
                    else{
                        for (String str : result) {
                            System.out.println(str);
                        }
                    }
                    cascadeBlanksAround(mineGrid.getGrid(), row, col);
//                    System.out.println("List of blank cells");
//                    for (String s : output) {
//                        System.out.println(s);
//                    }

                    System.out.println("\n");
                    mineGrid.revealCell(row, col);
                    mineGrid.revealGrid();
                }

            }
             catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers.");
            }
        }
    }

}
