package util;
import java.lang.*;

public class Grid {
    //Generate the game grid by calling this with a parameter
    public void generateGrid(int numRows, int numCols) {
        //Print column labels
        System.out.print(" \t");
        for(int i=0; i<numCols;i++){
            System.out.print(i + "\t");
        }
        System.out.println();



        //Print row labels

        for(int i=0; i<numRows-1; i++) {
                System.out.print(i + "\t");
            for(int j=0; j<numCols; j++) {
                    System.out.print("?\t");
            }
            System.out.print("\n");
        }
        return;
    }
}
