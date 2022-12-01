import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day1 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("aoc1.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        System.out.println(elfMostCalories(result));
    }

    public static int elfMostCalories(List<String> result) {
        List<Integer> maxValues = new ArrayList<>();
        maxValues.add(0);
        maxValues.add(0);
        maxValues.add(0);
        int count = 0;
        for (String s : result) {
            if (s.isEmpty() || s.isBlank()) {
                if (count > maxValues.get(0) || count > maxValues.get(1) || count > maxValues.get(2)) {
                    maxValues.set(2, count);
                    maxValues.sort(Collections.reverseOrder());
                }
                count = 0;
                continue;
            }
            count = count + Integer.parseInt(s);
        }
        return maxValues.get(0) + maxValues.get(1) + maxValues.get(2);
    }

}
