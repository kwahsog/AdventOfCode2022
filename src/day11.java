import java.io.IOException;
import java.util.*;

public class day11 {

    public static HashMap<Long, Monkey> exampleMonkeyMap = new HashMap<>();
    public static HashMap<Long, Monkey> oneTrueMonkeyMap = new HashMap<>();

    public static long NO_ITERATIONS = 10000;


    public static void main(String[] args) throws IOException {
        processTestCase();
        processAoC11();
    }

    public static void processAoC11() {
        Monkey monkey0 = new Monkey();
        monkey0.items.add(83L);
        monkey0.items.add(62L);
        monkey0.items.add(93L);
        monkey0.operation = OPERATION.MULTIPLY;
        monkey0.operationVal = 17;
        monkey0.divisibleBy = 2;
        monkey0.monkeyTargetTrue = 1;
        monkey0.monkeyTargetFalse = 6;
        monkey0.monkeyCleverMod = 2*17*19*3*5*13*7*11;

        Monkey monkey1 = new Monkey();
        monkey1.items.add(90L);
        monkey1.items.add(55L);
        monkey1.operation = OPERATION.ADD;
        monkey1.operationVal = 1;
        monkey1.divisibleBy = 17;
        monkey1.monkeyTargetTrue = 6;
        monkey1.monkeyTargetFalse = 3;
        monkey1.monkeyCleverMod = 2*17*19*3*5*13*7*11;

        Monkey monkey2 = new Monkey();
        monkey2.items.add(91L);
        monkey2.items.add(78L);
        monkey2.items.add(80L);
        monkey2.items.add(97L);
        monkey2.items.add(79L);
        monkey2.items.add(88L);
        monkey2.operation = OPERATION.ADD;
        monkey2.operationVal = 3;
        monkey2.divisibleBy = 19;
        monkey2.monkeyTargetTrue = 7;
        monkey2.monkeyTargetFalse = 5;
        monkey2.monkeyCleverMod = 2*17*19*3*5*13*7*11;

        Monkey monkey3 = new Monkey();
        monkey3.items.add(64L);
        monkey3.items.add(80L);
        monkey3.items.add(83L);
        monkey3.items.add(89L);
        monkey3.items.add(59L);
        monkey3.operation = OPERATION.ADD;
        monkey3.operationVal = 5;
        monkey3.divisibleBy = 3;
        monkey3.monkeyTargetTrue = 7;
        monkey3.monkeyTargetFalse = 2;
        monkey3.monkeyCleverMod = 2*17*19*3*5*13*7*11;

        Monkey monkey4 = new Monkey();
        monkey4.items.add(98L);
        monkey4.items.add(92L);
        monkey4.items.add(99L);
        monkey4.items.add(51L);
        monkey4.operation = OPERATION.SQUARE;
        monkey4.operationVal = -1;
        monkey4.divisibleBy = 5;
        monkey4.monkeyTargetTrue = 0;
        monkey4.monkeyTargetFalse = 1;
        monkey4.monkeyCleverMod = 2*17*19*3*5*13*7*11;

        Monkey monkey5 = new Monkey();
        monkey5.items.add(68L);
        monkey5.items.add(57L);
        monkey5.items.add(95L);
        monkey5.items.add(85L);
        monkey5.items.add(98L);
        monkey5.items.add(75L);
        monkey5.items.add(98L);
        monkey5.items.add(75L);
        monkey5.operation = OPERATION.ADD;
        monkey5.operationVal = 2;
        monkey5.divisibleBy = 13;
        monkey5.monkeyTargetTrue = 4;
        monkey5.monkeyTargetFalse = 0;
        monkey5.monkeyCleverMod = 2*17*19*3*5*13*7*11;

        Monkey monkey6 = new Monkey();
        monkey6.items.add(74L);
        monkey6.operation = OPERATION.ADD;
        monkey6.operationVal = 4;
        monkey6.divisibleBy = 7;
        monkey6.monkeyTargetTrue = 3;
        monkey6.monkeyTargetFalse = 2;
        monkey6.monkeyCleverMod = 2*17*19*3*5*13*7*11;

        Monkey monkey7 = new Monkey();
        monkey7.items.add(68L);
        monkey7.items.add(64L);
        monkey7.items.add(60L);
        monkey7.items.add(68L);
        monkey7.items.add(87L);
        monkey7.items.add(80L);
        monkey7.items.add(82L);
        monkey7.operation = OPERATION.MULTIPLY;
        monkey7.operationVal = 19;
        monkey7.divisibleBy = 11;
        monkey7.monkeyTargetTrue = 4;
        monkey7.monkeyTargetFalse = 5;
        monkey7.monkeyCleverMod = 2*17*19*3*5*13*7*11;

        oneTrueMonkeyMap.put(0L, monkey0);
        oneTrueMonkeyMap.put(1L, monkey1);
        oneTrueMonkeyMap.put(2L, monkey2);
        oneTrueMonkeyMap.put(3L, monkey3);
        oneTrueMonkeyMap.put(4L, monkey4);
        oneTrueMonkeyMap.put(5L, monkey5);
        oneTrueMonkeyMap.put(6L, monkey6);
        oneTrueMonkeyMap.put(7L, monkey7);

        for (long i = 0; i < NO_ITERATIONS; i++) {
            for (long j = 0; j < oneTrueMonkeyMap.size(); j++) {
                oneTrueMonkeyMap.get(j).monkeyDo(oneTrueMonkeyMap);
            }
        }

        System.out.println("Real monkeys done");
        var list = new ArrayList<Long>();
        oneTrueMonkeyMap.forEach((k, v) -> list.add(v.monkeyBusinessCount));
        list.sort(Collections.reverseOrder());
        System.out.println("Real monkey business: " + (list.get(0) * list.get(1)));
    }


    public static void processTestCase() {
        Monkey monkey0 = new Monkey();
        monkey0.items.add(79L);
        monkey0.items.add(98L);
        monkey0.operation = OPERATION.MULTIPLY;
        monkey0.operationVal = 19;
        monkey0.divisibleBy = 23;
        monkey0.monkeyTargetTrue = 2;
        monkey0.monkeyTargetFalse = 3;
        monkey0.monkeyCleverMod = 17*13*19*23;

        Monkey monkey1 = new Monkey();
        monkey1.items.add(54L);
        monkey1.items.add(65L);
        monkey1.items.add(75L);
        monkey1.items.add(74L);
        monkey1.operation = OPERATION.ADD;
        monkey1.operationVal = 6;
        monkey1.divisibleBy = 19;
        monkey1.monkeyTargetTrue = 2;
        monkey1.monkeyTargetFalse = 0;
        monkey1.monkeyCleverMod = 17*13*19*23;

        Monkey monkey2 = new Monkey();
        monkey2.items.add(79L);
        monkey2.items.add(60L);
        monkey2.items.add(97L);
        monkey2.operation = OPERATION.SQUARE;
        monkey2.operationVal = -1;
        monkey2.divisibleBy = 13;
        monkey2.monkeyTargetTrue = 1;
        monkey2.monkeyTargetFalse = 3;
        monkey2.monkeyCleverMod = 17*13*19*23;

        Monkey monkey3 = new Monkey();
        monkey3.items.add(74L);
        monkey3.operation = OPERATION.ADD;
        monkey3.operationVal = 3;
        monkey3.divisibleBy = 17;
        monkey3.monkeyTargetTrue = 0;
        monkey3.monkeyTargetFalse = 1;
        monkey3.monkeyCleverMod = 17*13*19*23;

        exampleMonkeyMap.put(0L, monkey0);
        exampleMonkeyMap.put(1L, monkey1);
        exampleMonkeyMap.put(2L, monkey2);
        exampleMonkeyMap.put(3L, monkey3);

        for (long i = 0; i < NO_ITERATIONS; i++) {
            for (long j = 0; j < exampleMonkeyMap.size(); j++) {
                exampleMonkeyMap.get(j).monkeyDo(exampleMonkeyMap);
            }
        }

        System.out.println("Test monkeys done");
        var list = new ArrayList<Long>();
        exampleMonkeyMap.forEach((k, v) -> list.add(v.monkeyBusinessCount));
        list.sort(Collections.reverseOrder());
        System.out.println("Monkey business: " + (list.get(0) * list.get(1)));
    }


    public static class Monkey {
        public Monkey() {

        }

        public List<Long> items = new ArrayList<>();
        public OPERATION operation = OPERATION.ADD; //default
        public long operationVal = -1;
        public long divisibleBy = -1;
        public long monkeyTargetTrue = -1;
        public long monkeyTargetFalse = -1;

        public long monkeyCleverMod = 0;

        public long monkeyBusinessCount = 0;

        public void monkeyDo(Map<Long, Monkey> monkeyMap) {
            for (Long x : items) {
                monkeyBusinessCount++;
                var newVal = this.inspect(x);
                //PT2: No longer div by 3.
//                newVal = Math.floorDiv(newVal, 3);
                newVal = newVal % monkeyCleverMod;

                if (newVal % divisibleBy == 0) {
                    monkeyMap.get(monkeyTargetTrue).monkeyGive(newVal);
                } else {
                    monkeyMap.get(monkeyTargetFalse).monkeyGive(newVal);
                }
            }
            items.clear();
        }

        public void monkeyGive(long item) {
            items.add(item);
        }

        public long inspect(long input) {
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
