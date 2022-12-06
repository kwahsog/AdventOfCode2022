import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day6 {

    public static final int MESSAGE_LENGTH = 14;

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("res/aoc6.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        System.out.println(uniqueCharSeq(result.get(0)));
    }

    public static int uniqueCharSeq(String result) {
        var chars = new ArrayList<Character>();
        for (int i = 0; i < result.length(); i++) {
            if (chars.size() < MESSAGE_LENGTH) {
                chars.add(result.charAt(i));
                continue;
            }
            chars.remove(0);
            chars.add(MESSAGE_LENGTH - 1, result.charAt(i));
            if (allUnique(chars)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static boolean allUnique(List<Character> list) {
        var set = new HashSet<>(list);
        return set.size() == MESSAGE_LENGTH;
    }

}

