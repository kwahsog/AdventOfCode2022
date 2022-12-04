import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day4 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("aoc4.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        System.out.println(countIntersections(result));
    }
    public static int countIntersections(List<String> result) {
        int count = 0;
        for (String s : result) {
            var x = s.split(",");
            var first = Integer.parseInt(x[0].split("-")[0]);
            var second = Integer.parseInt(x[0].split("-")[1]);
            var third = Integer.parseInt(x[1].split("-")[0]);
            var fourth = Integer.parseInt(x[1].split("-")[1]);
            if (first >= third && first <= fourth || second >= third && second <= fourth) {
                count++;
            } else if (third >= first && fourth <= second || fourth >= second && third <= first) {
                count++;
            }
        }
        return count;
    }




}
