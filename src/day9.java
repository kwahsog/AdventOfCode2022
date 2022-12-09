import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day9 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("res/aoc9.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        System.out.println(ropeMoving(result));
    }

    public static int ropeMoving(List<String> result) {

        var head = new Position(0,0);
        var tail = new Position(0,0);
        var tail2 = new Position(0,0);
        var tail3 = new Position(0,0);
        var tail4 = new Position(0,0);
        var tail5 = new Position(0,0);
        var tail6 = new Position(0,0);
        var tail7 = new Position(0,0);
        var tail8 = new Position(0,0);
        var tail9 = new Position(0,0);
        var list = new ArrayList<Position>();
        list.add(tail);
        list.add(tail2);
        list.add(tail3);
        list.add(tail4);
        list.add(tail5);
        list.add(tail6);
        list.add(tail7);
        list.add(tail8);
        list.add(tail9);
        var set = new HashSet<String>(); //set of all tail positions.

        for (int i = 0; i < result.size(); i++) {
            String instruction = result.get(i);
            String direction = instruction.split(" ")[0];
            int length = Integer.parseInt(instruction.split(" ")[1]);
            while (length > 0) {
                //move head
                head.move(direction, 1);
                length--;
                //move tail
                for (int j = 0; j < list.size(); j++) {
                    if (j == 0) {
                        moveRope(head, list.get(j));
                    } else {
                        moveRope(list.get(j - 1), list.get(j));
                    }
                }
                set.add(tail9.x + "," + tail9.y);
            }
        }

        return set.size();
    }

    public static void moveRope(Position head, Position tail) {
        if (head.x - 2 == tail.x && head.y == tail.y) {
            tail.x = tail.x + 1;
        }
        // head is directly to the left
        else if (head.x + 2 == tail.x && head.y == tail.y) {
            tail.x = tail.x - 1;
        }
        // head is directly to the up
        else if (head.y - 2 == tail.y && head.x == tail.x) {
            tail.y = tail.y + 1;
        }
        // head is directly to the down
        else if (head.y + 2 == tail.y && head.x == tail.x) {
            tail.y = tail.y - 1;
        }
        //diagonals 1
        else if (head.y - 2 == tail.y && head.x - 1 == tail.x) {
            tail.x = tail.x + 1;
            tail.y = tail.y + 1;
        }
        //diagonals 2
        else if (head.y - 1 == tail.y && head.x - 2 == tail.x) {
            tail.x = tail.x + 1;
            tail.y = tail.y + 1;
        }
        //diagonals 3
        else if (head.y + 1 == tail.y && head.x - 2 == tail.x) {
            tail.x = tail.x + 1;
            tail.y = tail.y - 1;
        }
        //diagonals 4
        else if (head.y + 2 == tail.y && head.x - 1 == tail.x) {
            tail.x = tail.x + 1;
            tail.y = tail.y - 1;
        }
        //diagonals 5
        else if (head.y + 2 == tail.y && head.x + 1 == tail.x) {
            tail.x = tail.x - 1;
            tail.y = tail.y - 1;
        }
        //diagonals 6
        else if (head.y + 1 == tail.y && head.x + 2 == tail.x) {
            tail.x = tail.x - 1;
            tail.y = tail.y - 1;
        }
        //diagonals 7
        else if (head.y - 1 == tail.y && head.x + 2 == tail.x) {
            tail.x = tail.x - 1;
            tail.y = tail.y + 1;
        }
        //diagonals 8
        else if (head.y - 2 == tail.y && head.x + 1 == tail.x) {
            tail.x = tail.x - 1;
            tail.y = tail.y + 1;
        }
        //MORE DIAGONALS
        else if (head.y - 2 == tail.y && head.x - 2 == tail.x) {
            tail.x = tail.x + 1;
            tail.y = tail.y + 1;
        }
        else if (head.y - 2 == tail.y && head.x + 2 == tail.x) {
            tail.x = tail.x - 1;
            tail.y = tail.y + 1;
        }
        else if (head.y + 2 == tail.y && head.x + 2 == tail.x) {
            tail.x = tail.x - 1;
            tail.y = tail.y - 1;
        }
        else if (head.y + 2 == tail.y && head.x - 2 == tail.x) {
            tail.x = tail.x + 1;
            tail.y = tail.y - 1;
        }
        //same position, do nothing

    }

    public static class Position {

        public int x;
        public int y;
        public Position(int startingx, int startingy) {
            this.x = startingx;
            this.y = startingy;
        }

        public void move(String direction, int length) {
                switch (direction) {
                    case "R":
                        x = x + length;
                        return;
                    case "L":
                        x = x - length;
                        return;
                    case "U":
                        y = y + length;
                        return;
                    case "D":
                        y = y - length;
                        return;
                }
        }
    }
}
