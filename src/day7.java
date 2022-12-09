import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day7 {

    //my recommendation is to always store each directory as an absolute path,
    // and store them as a dictionary of absolute path to (subdirectories as absolute paths, total size).
    // then you can trivially turn it into a while loop with a stack or queue for subdirectories

    //def dir_size(all_dirs, start):
    //    total = 0
    //    todo = [start]
    //    while todo:
    //        current = todo.pop()
    //        subdirs, files = all_dirs[current]
    //        total += files
    //        for d in subdirs:
    //            todo.append(d)
    //
    //    return total
    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("res/aoc7.txt"))) {
            result = lines.collect(Collectors.toList());
        }
        parseInput(result);
        long finalSum = 0;
        for (Map.Entry<String, List<String>> entry : files.entrySet()) {
            var temp = sizeOfDir(entry.getKey());
//            System.out.println("Size of :" + entry.getKey() + " : " + temp);
            if (temp <= 100000) {
                finalSum = temp + finalSum;
            }
        }
        System.out.println("PART1: " + finalSum);

        long rootSum = sizeOfDir("root");
        System.out.println("RootSize: " + rootSum);
        long remainingSpace = 70000000 - rootSum;
        System.out.println("Space remanining: " + remainingSpace);
        long spaceNeeded = 30000000 - remainingSpace;
        System.out.println("Space needed: " + spaceNeeded);

        var aaa = new ArrayList<Long>();
        for (Map.Entry<String, List<String>> entry : files.entrySet()) {
            var temp = sizeOfDir(entry.getKey());
            aaa.add(temp);
        }
        aaa.sort(Comparator.naturalOrder());
        long finalAnswer = 0;
        for (long x : aaa) {
            if (x >= spaceNeeded) {
                finalAnswer = x;
                break;
            }
        }
        System.out.println("PART2: " + finalAnswer);

    }
    //Map<DIR NAME, files>
    //Map<DIR NAME, listOfSubDirs>
    public static HashMap<String, List<String>> files = new HashMap<>();
    public static HashMap<String, List<String>> subDirs = new HashMap<>();

    public static long sizeOfDir(String dirName) {
        AtomicLong sum = new AtomicLong();

        files.get(dirName).forEach((x) -> {
            String fileName = x.split(",")[0];
            long fileSize = Long.parseLong(x.split(",")[1]);
            sum.addAndGet(fileSize);
        });

        for (Map.Entry<String, List<String>> entry : files.entrySet()) {
           if (entry.getKey().startsWith(dirName + "|")) {
               entry.getValue().forEach((x) -> {
                   String fileName = x.split(",")[0];
                   long fileSize = Long.parseLong(x.split(",")[1]);
                   sum.addAndGet(fileSize);
               });
           }
        }
        return sum.get();
    }

    public static void parseInput(List<String> result) {
        int i = 1;
        String currDirectory = "root";
        while (i < result.size() - 1) {
            if (result.get(i).equals("$ ls")) {
                i++;
                while (i < result.size() && !result.get(i).startsWith("$")) {
                    if (result.get(i).startsWith("dir")) {
                        String dir = result.get(i).substring(4);
//                        var currDirs = subDirs.get(currDirectory);
//                        if (currDirs == null) {
//                            currDirs = new ArrayList<>();
//                        }
//                        currDirs.add(dir);
//                        subDirs.put(currDirectory, currDirs);
                        var currFiles = files.get(currDirectory);
                        if (currFiles == null) {
                            currFiles = new ArrayList<>();
                        }
                        currFiles.add("empty" +","+0);
                        files.put(currDirectory, currFiles);
                    } else {
                        String fileName = result.get(i).split(" ")[1];
                        long fileSize = Long.parseLong(result.get(i).split(" ")[0]);
                        var currFiles = files.get(currDirectory);
                        if (currFiles == null) {
                            currFiles = new ArrayList<>();
                        }
                        currFiles.add(fileName +","+fileSize);
                        files.put(currDirectory, currFiles);
                    }
                    i++;
                }
            } else if (result.get(i).startsWith("$ cd")) {
                String folder = result.get(i).substring(5);
                if (folder.equals("..")) {
                    int lastIndex = currDirectory.lastIndexOf("|");
                    currDirectory = currDirectory.substring(0, lastIndex);
                } else {
                    currDirectory = currDirectory + "|" + folder;
                }
                i++;
            }
        }
    }
}
