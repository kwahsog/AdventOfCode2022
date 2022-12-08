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
        var x = parseInput(result);
        var result2 = computeTrees(x);
        System.out.println((result2));
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
        int totalNoTrees = 0;

//        boolean x = computeUp(grid, 1, 4);
//        boolean y = computeDown(grid, 1, 4);
//        boolean z = computeLeft(grid, 1, 4);
//        boolean m = computeRight(grid, 1, 4);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < length; j++) {

                var result = computeUp(grid, i, j) || computeDown(grid, i, j) || computeLeft(grid, i, j) || computeRight(grid, i, j);
                boolean up = computeUp(grid, i, j);
                boolean down = computeDown(grid, i, j);
                boolean left = computeLeft(grid, i, j);
                boolean right = computeRight(grid, i, j);
                System.out.println(String.format("value: %s, up %s , down %s, left %s, right %s", grid[i][j], up, down, left, right));

                if (result) {
                    System.out.println("Result true: " + i + "," + j);
                    totalNoTrees++;
                }
            }
        }
        return totalNoTrees;
    }

    public static boolean computeDown(int[][] grid, int startingx, int startingy) {
//        if (startingy == 0) {
//            return true;
//        }
        int maxVal = grid[startingx][startingy];
        boolean success = true;
        int adjustedX = startingx + 1;
        while (adjustedX < grid.length) {
            int currVal = grid[adjustedX][startingy];
            if (currVal < maxVal) {
                adjustedX++;
            } else {
                return false;
            }
        }
        return success;
    }


//    up false , down true, left false, right true
//    Result true: 1,4
    public static boolean computeUp(int[][] grid, int startingx, int startingy) {
//        if (startingy == 0) {
//            return true;
//        }
        int maxVal = grid[startingx][startingy];
        boolean success = true;
        int adjustedX = startingx - 1;
        while (adjustedX > -1) {
            int currVal = grid[adjustedX][startingy];
            if (currVal < maxVal) {
                adjustedX--;
            } else {
                return false;
            }
        }
        return success;
    }


    public static boolean computeLeft(int[][] grid, int startingx, int startingy) {
//        if (startingy == 0) {
//            return true;
//        }
        int maxVal = grid[startingx][startingy];
        boolean success = true;
        int adjustedY = startingy - 1;
        while (adjustedY > -1) {
            int currVal = grid[startingx][adjustedY];
            if (currVal < maxVal) {
                adjustedY--;
            } else {
                return false;
            }
        }
        return success;
    }

    public static boolean computeRight(int[][] grid, int startingx, int startingy) {
//        if (startingy == 0) {
//            return true;
//        }
        int maxVal = grid[startingx][startingy];
        boolean success = true;
        int adjustedY = startingy + 1;
        while (adjustedY < grid.length) {
            int currVal = grid[startingx][adjustedY];
            if (currVal < maxVal) {
                adjustedY++;
            } else {
                return false;
            }
        }
        return success;
    }
}
