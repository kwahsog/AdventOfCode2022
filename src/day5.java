import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day5 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("aoc5.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        System.out.println(ruckSackSum(result));
    }

    public static String ruckSackSum(List<String> result) {

        var stack1 = new Stack<String>();
        stack1.push("N");
        stack1.push("C");
        stack1.push("R");
        stack1.push("T");
        stack1.push("M");
        stack1.push("Z");
        stack1.push("P");

        var stack2 = new Stack<String>();
        stack2.push("D");
        stack2.push("N");
        stack2.push("T");
        stack2.push("S");
        stack2.push("B");
        stack2.push("Z");

        var stack3 = new Stack<String>();
        stack3.push("M");
        stack3.push("H");
        stack3.push("Q");
        stack3.push("R");
        stack3.push("F");
        stack3.push("C");
        stack3.push("T");
        stack3.push("G");

        var stack4 = new Stack<String>();
        stack4.push("G");
        stack4.push("R");
        stack4.push("Z");

        var stack5 = new Stack<String>();
        stack5.push("Z");
        stack5.push("N");
        stack5.push("R");
        stack5.push("H");

        var stack6 = new Stack<String>();
        stack6.push("F");
        stack6.push("H");
        stack6.push("S");
        stack6.push("W");
        stack6.push("P");
        stack6.push("Z");
        stack6.push("L");
        stack6.push("D");

        var stack7 = new Stack<String>();
        stack7.push("W");
        stack7.push("D");
        stack7.push("Z");
        stack7.push("R");
        stack7.push("C");
        stack7.push("G");
        stack7.push("M");

        var stack8 = new Stack<String>();
        stack8.push("S");
        stack8.push("J");
        stack8.push("F");
        stack8.push("L");
        stack8.push("H");
        stack8.push("W");
        stack8.push("Z");
        stack8.push("Q");

        var stack9 = new Stack<String>();
        stack9.push("S");
        stack9.push("Q");
        stack9.push("P");
        stack9.push("W");
        stack9.push("N");

        var arr = new ArrayList<Stack<String>>();
        arr.add(stack1);
        arr.add(stack2);
        arr.add(stack3);
        arr.add(stack4);
        arr.add(stack5);
        arr.add(stack6);
        arr.add(stack7);
        arr.add(stack8);
        arr.add(stack9);

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).length() == 0 || result.get(i).charAt(0) != 'm') {
                continue;
            }
            int noMoves = Integer.parseInt(result.get(i).split(" ")[1]);
            int fromStack = Integer.parseInt(result.get(i).split(" ")[3]);
            int toStack = Integer.parseInt(result.get(i).split(" ")[5]);
            for (int j = 0; j < noMoves; j++) {
                var ele = arr.get(fromStack - 1).pop();
                arr.get(toStack - 1).add(ele);
            }
        }

        arr.forEach((x)-> {
            System.out.print(x.peek());
        });

        return "0";
    }


}

