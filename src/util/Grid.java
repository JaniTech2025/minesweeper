package util;

import java.util.ArrayList;

import static util.MyUtils.isInBounds;

//import static util.MyUtils.cascadeBlanksAround;

public class Grid {
    private Cell[][] grid;



    public void generateGrid(int numRows, int numCols) {

        grid = new Cell[numRows][numCols];

        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j < numCols; j++) {
//                System.out.print(j + " ");

                grid[i][j] = new Blank();

            }
        }



        int[][] randBombSites = MyUtils.generateRandomPositions(numRows, numCols);
        for (int[] pos : randBombSites) {
            int row = pos[0];
            int col = pos[1];
            grid[row][col] = new Bomb();
        }

        assignNumbersAroundBombs(numRows, numCols);
//        System.out.println("\n");

    }




    public void revealGrid() {
        System.out.print("  ");
        for (int i = 0; i < grid.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(i + " ");
//            if(i == grid.length - 1) {System.out.print("");}
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public void revealCell(int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            grid[row][col].reveal(row, col);
        } else {
            System.out.println("Invalid coordinates.");
        }
    }



    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    private void assignNumbersAroundBombs(int numRows, int numCols) { //Around every bomb cell
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] instanceof Bomb) {
                    MyUtils.updateNeighbors(grid, i, j);
                }
            }
        }
    }















}
