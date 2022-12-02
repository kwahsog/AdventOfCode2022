import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day2 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("aoc2.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        System.out.println(rpsResult(result));
    }


    //A Y draw, so pick the same (A=X)
    //B X lose, so pick wrong (X)
    //C Z win, so pick winner (X)
    public static int rpsResult(List<String> result) {
        int sum = 0;
        for (String s : result) {
            sum += calculateScore(returnWantedResult(s));
        }
        return sum;
    }

    public static String returnWantedResult(String x) {
        switch (x){
            //A rock
            //B paper
            //C scissors
            //X rock = 1
            //Y paper = 2
            //Z scissors = 3
            //loss = 0, draw = 3, win = 6;

            //A X lose, so pick wrong (X)
            //A Y draw, so pick the same (A=Y)
            //A Z win, so pick winner (X)
            case "A X":
                return "A Z";
            case "A Y":
                return "A X";
            case "A Z":
                return "A Y";
            case "B X":
                return "B X";
            case "B Y":
                return "B Y";
            case "B Z":
                return "B Z";
            case "C X":
                return "C Y";
            case "C Y":
                return "C Z";
            case "C Z":
                return "C X";
            default:
                return "";
        }
    }

    public static int calculateScore(String x) {
        switch (x){
            //A rock
            //B paper
            //C scissors
            //X rock = 1
            //Y paper = 2
            //Z scissors = 3
            //loss = 0, draw = 3, win = 6;
            case "A X":
                return 1 + 3;
            case "A Y":
                return 2 + 6;
            case "A Z":
                return 3 + 0;
            case "B X":
                return 1 + 0;
            case "B Y":
                return 2 + 3;
            case "B Z":
                return 3 + 6;
            case "C X":
                return 1 + 6;
            case "C Y":
                return 2 + 0;
            case "C Z":
                return 3 + 3;
            default:
                return 0;
        }
    }

}
