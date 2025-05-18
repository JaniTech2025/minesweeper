package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MyUtils {

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

}
