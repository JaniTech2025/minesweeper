package util;

public class Grid {
    private Cell[][] grid;

    public void generateGrid(int numRows, int numCols) {
        grid = new Cell[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
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
    }



    public void revealGrid() {
        for (int i = 0; i < grid.length; i++) {
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

    private void assignNumbersAroundBombs(int numRows, int numCols) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] instanceof Bomb) {
                    updateNeighbors(i, j);
                }
            }
        }
    }

    private void updateNeighbors(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) continue;
                if (isInBounds(i, j)) {
                    if (grid[i][j] instanceof Blank) {
                        grid[i][j] = new Number(1);
                    } else if (grid[i][j] instanceof Number) {
                        Number numberCell = (Number) grid[i][j];
                        int newCount = numberCell.getBombCount() + 1;
                        grid[i][j] = new Number(newCount);
                    }
                }
            }
        }
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

}
