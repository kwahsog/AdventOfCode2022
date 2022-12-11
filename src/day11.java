import java.io.IOException;
import java.util.*;

public class day11 {

    public static HashMap<Integer, Monkey> exampleMonkeyMap = new HashMap<>();
    public static HashMap<Integer, Monkey> oneTrueMonkeyMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        List<String> result;
//        try (Stream<String> lines = Files.lines(Paths.get("res/aoc11.txt"))) {
//            result = lines.collect(Collectors.toList());
//        }

//        processTestCase();
        processAoC11();
    }

    public static void processAoC11() {
        Monkey monkey0 = new Monkey();
        monkey0.items.add(83);
        monkey0.items.add(62);
        monkey0.items.add(93);
        monkey0.operation = OPERATION.MULTIPLY;
        monkey0.operationVal = 17;
        monkey0.divisibleBy = 2;
        monkey0.monkeyTargetTrue = 1;
        monkey0.monkeyTargetFalse = 6;

        Monkey monkey1 = new Monkey();
        monkey1.items.add(90);
        monkey1.items.add(55);
        monkey1.operation = OPERATION.ADD;
        monkey1.operationVal = 1;
        monkey1.divisibleBy = 17;
        monkey1.monkeyTargetTrue = 6;
        monkey1.monkeyTargetFalse = 3;

        Monkey monkey2 = new Monkey();
        monkey2.items.add(91);
        monkey2.items.add(78);
        monkey2.items.add(80);
        monkey2.items.add(97);
        monkey2.items.add(79);
        monkey2.items.add(88);
        monkey2.operation = OPERATION.ADD;
        monkey2.operationVal = 3;
        monkey2.divisibleBy = 19;
        monkey2.monkeyTargetTrue = 7;
        monkey2.monkeyTargetFalse = 5;

        Monkey monkey3 = new Monkey();
        monkey3.items.add(64);
        monkey3.items.add(80);
        monkey3.items.add(83);
        monkey3.items.add(89);
        monkey3.items.add(59);
        monkey3.operation = OPERATION.ADD;
        monkey3.operationVal = 5;
        monkey3.divisibleBy = 3;
        monkey3.monkeyTargetTrue = 7;
        monkey3.monkeyTargetFalse = 2;

        Monkey monkey4 = new Monkey();
        monkey4.items.add(98);
        monkey4.items.add(92);
        monkey4.items.add(99);
        monkey4.items.add(51);
        monkey4.operation = OPERATION.SQUARE;
        monkey4.operationVal = -1;
        monkey4.divisibleBy = 5;
        monkey4.monkeyTargetTrue = 0;
        monkey4.monkeyTargetFalse = 1;

        Monkey monkey5 = new Monkey();
        monkey5.items.add(68);
        monkey5.items.add(57);
        monkey5.items.add(95);
        monkey5.items.add(85);
        monkey5.items.add(98);
        monkey5.items.add(75);
        monkey5.items.add(98);
        monkey5.items.add(75);
        monkey5.operation = OPERATION.ADD;
        monkey5.operationVal = 2;
        monkey5.divisibleBy = 13;
        monkey5.monkeyTargetTrue = 4;
        monkey5.monkeyTargetFalse = 0;

        Monkey monkey6 = new Monkey();
        monkey6.items.add(74);
        monkey6.operation = OPERATION.ADD;
        monkey6.operationVal = 4;
        monkey6.divisibleBy = 7;
        monkey6.monkeyTargetTrue = 3;
        monkey6.monkeyTargetFalse = 2;

        Monkey monkey7 = new Monkey();
        monkey7.items.add(68);
        monkey7.items.add(64);
        monkey7.items.add(60);
        monkey7.items.add(68);
        monkey7.items.add(87);
        monkey7.items.add(80);
        monkey7.items.add(82);
        monkey7.operation = OPERATION.MULTIPLY;
        monkey7.operationVal = 19;
        monkey7.divisibleBy = 11;
        monkey7.monkeyTargetTrue = 4;
        monkey7.monkeyTargetFalse = 5;

        oneTrueMonkeyMap.put(0, monkey0);
        oneTrueMonkeyMap.put(1, monkey1);
        oneTrueMonkeyMap.put(2, monkey2);
        oneTrueMonkeyMap.put(3, monkey3);
        oneTrueMonkeyMap.put(4, monkey4);
        oneTrueMonkeyMap.put(5, monkey5);
        oneTrueMonkeyMap.put(6, monkey6);
        oneTrueMonkeyMap.put(7, monkey7);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < oneTrueMonkeyMap.size(); j++) {
                oneTrueMonkeyMap.get(j).monkeyDo();
            }
        }

        System.out.println("Test monkeys done");
        var list = new ArrayList<Integer>();
        oneTrueMonkeyMap.forEach((k, v) -> list.add(v.monkeyBusinessCount));
        list.sort(Collections.reverseOrder());
        System.out.println("Monkey business: " + (list.get(0) * list.get(1)));
    }



    public static void processTestCase() {
        Monkey monkey0 = new Monkey();
        monkey0.items.add(79);
        monkey0.items.add(98);
        monkey0.operation = OPERATION.MULTIPLY;
        monkey0.operationVal = 19;
        monkey0.divisibleBy = 23;
        monkey0.monkeyTargetTrue = 2;
        monkey0.monkeyTargetFalse = 3;

        Monkey monkey1 = new Monkey();
        monkey1.items.add(54);
        monkey1.items.add(64);
        monkey1.items.add(75);
        monkey1.items.add(74);
        monkey1.operation = OPERATION.ADD;
        monkey1.operationVal = 6;
        monkey1.divisibleBy = 19;
        monkey1.monkeyTargetTrue = 2;
        monkey1.monkeyTargetFalse = 0;

        Monkey monkey2 = new Monkey();
        monkey2.items.add(79);
        monkey2.items.add(60);
        monkey2.items.add(97);
        monkey2.operation = OPERATION.SQUARE;
        monkey2.operationVal = -1;
        monkey2.divisibleBy = 13;
        monkey2.monkeyTargetTrue = 1;
        monkey2.monkeyTargetFalse = 3;

        Monkey monkey3 = new Monkey();
        monkey3.items.add(74);
        monkey3.operation = OPERATION.ADD;
        monkey3.operationVal = 3;
        monkey3.divisibleBy = 17;
        monkey3.monkeyTargetTrue = 0;
        monkey3.monkeyTargetFalse = 1;

        exampleMonkeyMap.put(0, monkey0);
        exampleMonkeyMap.put(1, monkey1);
        exampleMonkeyMap.put(2, monkey2);
        exampleMonkeyMap.put(3, monkey3);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < exampleMonkeyMap.size(); j++) {
                exampleMonkeyMap.get(j).monkeyDo();
            }
        }

        System.out.println("Test monkeys done");
        var list = new ArrayList<Integer>();
        exampleMonkeyMap.forEach((k, v) -> list.add(v.monkeyBusinessCount));
        list.sort(Collections.reverseOrder());
        System.out.println("Monkey business: " + (list.get(0) * list.get(1)));
    }


    public static class Monkey {
        public Monkey() {

        }

        public List<Integer> items = new ArrayList<>();
        public OPERATION operation = OPERATION.ADD; //default
        public int operationVal = -1;
        public int divisibleBy = -1;
        public int monkeyTargetTrue = -1;
        public int monkeyTargetFalse = -1;

        public int monkeyBusinessCount = 0;

        public void monkeyDo() {
            for (Integer x : items) {
                monkeyBusinessCount++;
                var newVal = this.inspect(x);
                newVal = Math.floorDiv(newVal, 3);

                if (newVal % divisibleBy == 0) {
                    oneTrueMonkeyMap.get(monkeyTargetTrue).monkeyGive(newVal);
                } else {
                    oneTrueMonkeyMap.get(monkeyTargetFalse).monkeyGive(newVal);
                }
            }
            items.clear();
        }

        public void monkeyGive(int item) {
            items.add(item);
        }

        public int inspect(int input) {
            switch (operation) {
                case ADD: {
                    return input + operationVal;
                }
                case SQUARE: {
                    return input * input;
                }
                case MULTIPLY: {
                    return input * operationVal;
                }
            }
            System.out.println("Error");
            return 0;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Monkey monkey = (Monkey) o;
            return operationVal == monkey.operationVal && divisibleBy == monkey.divisibleBy && monkeyTargetTrue == monkey.monkeyTargetTrue && monkeyTargetFalse == monkey.monkeyTargetFalse && Objects.equals(items, monkey.items) && operation == monkey.operation;
        }

        @Override
        public int hashCode() {
            return Objects.hash(items, operation, operationVal, divisibleBy, monkeyTargetTrue, monkeyTargetFalse);
        }
    }

    public static enum OPERATION {
        ADD,
        MULTIPLY,
        SQUARE,
    }


}
