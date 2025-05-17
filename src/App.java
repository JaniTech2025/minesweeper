
import util.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
            Grid mineGrid = new Grid();
            //To validate min and max values for the game
            mineGrid.generateGrid(5,5);

            System.out.println("Enter row, column");

            //To validate for max rows and columns
            Scanner scan = new Scanner(System.in);
            int row = scan.nextInt();
            int col = scan.nextInt();
            scan.close();
            System.out.println(row + col);
    }
}
