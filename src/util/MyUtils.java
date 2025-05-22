package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MyUtils {

    private static Cell[][] grid;
    private static int row;
    private static int col;

    public MyUtils(Cell[][] grid) {
        MyUtils.grid = grid;
    }


    public static int[][] generateRandomPositions(int numRows, int numCols) {
        double percentage = 0.2;
        int totalCells = numRows * numCols;
        int count = (int) (percentage * totalCells);

        Set<String> uniquePositions = new HashSet<>();
        Random rand = new Random();

        while (uniquePositions.size() < count) {
            int row = rand.nextInt(numRows);
            int col = rand.nextInt(numCols);
            uniquePositions.add(row + "," + col);
        }

        int[][] result = new int[count][2];
        int index = 0;
        for (String pos : uniquePositions) {
            String[] parts = pos.split(",");
            result[index][0] = Integer.parseInt(parts[0]);
            result[index][1] = Integer.parseInt(parts[1]);
            index++;
        }

        return result;
    }


    //Check for win or continue
    public static boolean gameWin(Cell[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell cell = grid[i][j];
                if((cell instanceof Number || cell instanceof Blank) && (cell.isNotRevealed(i, j))){
                   return false;
                }
            }
        }
        return true;
    }

    public static boolean bombUncovered(Cell[][] grid, int row, int col){
        Cell cell = grid[row][col];
        return cell instanceof Bomb;
    }

    public static void updateNeighbors(Cell[][] grid, int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) continue; // current cell around which numbers are to be placed
                if (isInBounds(grid, i, j)) {
                    if (grid[i][j] instanceof Blank) {
                        grid[i][j] = new Number(1);
                    } else if (grid[i][j] instanceof Number numberCell) {
                        int newCount = numberCell.getBombCount() + 1;
                        grid[i][j] = new Number(newCount);
                    }

                }
            }
        }
    }
    public static boolean isInBounds(Cell[][] grid,int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid.length;
    }

    public static ArrayList<String> getBombsAround(Cell[][] grid, int row, int col) {
        ArrayList<String> output = new ArrayList<String>();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) continue; // current cell around which numbers are to be placed
                if (isInBounds(grid, i, j)) {
                    if ((grid[i][j] instanceof Number numberCell) && (grid[i][j].isNotRevealed(i, j))){
                        int count = numberCell.getBombCount();
                        output.add(String.format("[%d, %d]: %d", i, j, count));
                    }
//                    else{
//                        output.add(String.format("[%d, %d]: 1", i, j));
//                    }
//
                }
            }
        }
        return output;
    }


    public static void cascadeBlanksAround(Cell[][] grid, int row, int col){

        if (isInBounds(grid, row, col)) {
            Cell cell = grid[row][col];
            if ((cell instanceof Bomb) || (cell instanceof Number)){return;}
            if (cell.isNotRevealed(row, col))
            {
                cell.reveal(row, col);
                cascadeBlanksAround(grid, row-1,col-1);
                cascadeBlanksAround(grid, row-1,col);
                cascadeBlanksAround(grid, row-1,col+1);
                cascadeBlanksAround(grid, row,col-1);
                cascadeBlanksAround(grid, row,col+1);
                cascadeBlanksAround(grid, row+1,col-1);
                cascadeBlanksAround(grid,row+1,col);
                cascadeBlanksAround(grid,row+1,col+1);
            }
        }
    }




}
