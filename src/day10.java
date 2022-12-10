import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day10 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("res/aoc10.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        var map = cycleSum(result);
        System.out.println("Solution 1: " + (map.get(20) * 20 + map.get(60) * 60 + map.get(100) * 100 + map.get(140) * 140 + map.get(180) * 180 + map.get(220) * 220));
    }



    public static Map<Integer, Integer> cycleSum(List<String> result) {
        //map of cycle and sum of X.
        var map = new HashMap<Integer, Integer>();
        int cycleNo = 1;
        int sumOfX = 1;

        var secondStack = new ArrayDeque<String>();
        for (String todo: result) {
            if (todo.equals("noop")) {
                secondStack.addLast("");
            } else  {
            secondStack.addLast("");
            secondStack.addLast(todo);
            }
        }
        while (!secondStack.isEmpty()) {
            System.out.println("During Cycle no: " + cycleNo + " sum: " + sumOfX);
            map.put(cycleNo, sumOfX);
            var x = secondStack.pop();
            if (!x.isEmpty()) {
                sumOfX = sumOfX + Integer.parseInt(x.split(" ")[1]);
            }
            cycleNo++;
        }
        return map;
    }

}
