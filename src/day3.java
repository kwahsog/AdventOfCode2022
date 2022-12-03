import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day3 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("aoc3.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        System.out.println(ruckSackSum(result));
    }

    public static int ruckSackSum(List<String> result) {
        var firstSet = new HashSet<Character>();
        var secondSet = new HashSet<Character>();
        int sum = 0;
        result.add(0, "");
        int modCountTwo = 2;
        int modCountThree = 3;
        for (int i = 0; i < result.size(); i++) {
            var items = result.get(i);
            if (items.equals("")) {
                continue;
            }
            if (i % modCountTwo == 0) {
                for (int j = 0; j < items.length(); j++) {
                    secondSet.add(items.charAt(j));
                }
            } else if (i % modCountThree == 0) {
                for (int j = 0; j < items.length(); j++) {
                    if (firstSet.contains(items.charAt(j)) && secondSet.contains(items.charAt(j))) {
                        sum += getRuckSackVal(items.charAt(j));
                        firstSet.clear();
                        secondSet.clear();
                        modCountTwo += 3;
                        modCountThree += 3;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < items.length(); j++) {
                    firstSet.add(items.charAt(j));
                }
            }
        }
        return sum;
    }


    public static int ruckSackSum1(List<String> result) {
        var charactersSet = new HashSet<Character>();
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            String first = result.get(i).substring(0, result.get(i).length()/2);
            String last = result.get(i).substring(result.get(i).length()/2);

            for (int j = 0; j < first.length(); j++) {
                charactersSet.add(first.charAt(j));
            }
            for (int k = 0; k < last.length(); k++) {
                if (charactersSet.contains(last.charAt(k))){
                    sum += getRuckSackVal(last.charAt(k));
                    break;
                }
            }
            charactersSet.clear();

        }
        return sum;
    }

    public static int getRuckSackVal(char x) {
        if (Character.isUpperCase(x)) {
            return x - 'A' + 1 + 26;
        } else {
            return x - 'a' + 1;
        }
    }

}
