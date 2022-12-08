import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day8 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("res/aoc8.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        var grid = parseInput(result);
        System.out.println((computeTrees(grid)));
    }


    public static int[][] parseInput(List<String> result) {
        int[][] grid = new int[result.size()][result.get(0).length()];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(0).length(); j++) {
                grid[i][j] = Integer.parseInt(String.valueOf(result.get(i).charAt(j)));
            }
        }
        return grid;
    }

    public static int computeTrees(int[][] grid) {
        int length = grid[0].length;
        int maxSum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < length; j++) {
               var result = computeUp(grid, i, j) * computeDown(grid, i, j) * computeLeft(grid, i, j) * computeRight(grid, i, j);
               if (result > maxSum) {
                    System.out.println("Result found: " + i + "," + j);
                    maxSum = result;
                }
            }
        }
        return maxSum;
    }

    public static int computeDown(int[][] grid, int startingx, int startingy) {
        int maxVal = grid[startingx][startingy];
        int sum = 0;
        int adjustedX = startingx + 1;
        while (adjustedX < grid.length) {
            int currVal = grid[adjustedX][startingy];
            sum++;
            if (currVal < maxVal) {
                adjustedX++;
            } else {
                return sum;
            }
        }
        return sum;
    }

    public static int computeUp(int[][] grid, int startingx, int startingy) {
        int maxVal = grid[startingx][startingy];
        int sum = 0;
        int adjustedX = startingx - 1;
        while (adjustedX > -1) {
            int currVal = grid[adjustedX][startingy];
            sum++;
            if (currVal < maxVal) {
                adjustedX--;
            } else {
                return sum;
            }
        }
        return sum;
    }


    public static int computeLeft(int[][] grid, int startingx, int startingy) {
        int maxVal = grid[startingx][startingy];
        int sum = 0;
        int adjustedY = startingy - 1;
        while (adjustedY > -1) {
            int currVal = grid[startingx][adjustedY];
            sum++;
            if (currVal < maxVal) {
                adjustedY--;
            } else {
                return sum;
            }
        }
        return sum;
    }

    public static int computeRight(int[][] grid, int startingx, int startingy) {
        int maxVal = grid[startingx][startingy];
        int sum = 0;
        int adjustedY = startingy + 1;
        while (adjustedY < grid.length) {
            int currVal = grid[startingx][adjustedY];
            sum++;
            if (currVal < maxVal) {
                adjustedY++;
            } else {
                return sum;
            }
        }
        return sum;
    }
}
