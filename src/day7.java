import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class day7 {

    public static void main(String[] args) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get("res/aoc7.txt"))) {
            result = lines.collect(Collectors.toList());
        }
//        System.out.println(parseInput(result));

        uniqueCharSeq("a");
        System.out.println(totalSum);
    }


    public static FileTree parseInput(List<String> result) {
        FileTree root = new FileTree("root");
        var curr = root;

        for (int i = 0; i < result.size(); i++) {

            if (i == 0) {
                continue; //start at root, skip
            }

            if (result.get(i).equals("$ ls")) {
                i++;
                while (!result.get(i).startsWith("$")) {
                    if (result.get(i).startsWith("dir")) {
                        String dir =  result.get(i).substring(4);
                        curr.children.put(dir, new FileTree(dir));
                    } else {
                        String fileName = result.get(i).split(" ")[1];
                        Integer fileSize = Integer.parseInt(result.get(i).split(" ")[0]);
                        curr.files.put(fileName, fileSize);
                    }
                    i++;
                }
            } else if (result.get(i).startsWith("$ cd")) {
                String folder = result.get(i).substring(4);
                if (folder.equals("..")) {
//                    curr = curr.children.get("a"); //need to get node above
                } else {
                    curr = curr.children.get(folder);
                }
            }
        }

        return root;
    }


    public static int uniqueCharSeq(String result) {

        FileTree root = new FileTree("root");

        root.files.put("b.txt", 14848514);
        root.files.put("c.dat", 8504156);

        root.children.put("a", new FileTree("a"));
        var curr = root.children.get("a");
        curr.files.put("f", 29116);
        curr.files.put("g", 2557);
        curr.files.put("h.lst", 62596);

        curr.children.put("e", new FileTree("e"));
        curr = curr.children.get("e");
        curr.files.put("i", 584);

        root.children.put("d", new FileTree("d"));
        curr = root.children.get("d");
        curr.files.put("j", 4060174);
        curr.files.put("d.log", 8033020);
        curr.files.put("d.ext", 5626152);
        curr.files.put("k", 7214296);

        return dfs(root, 0);
    }


    public static int totalSum = 0;

    public static int dfs(FileTree fileTree, int childSize2) {
        //time to do DFS lol
        System.out.println("dfs for:" + fileTree.name);
        int sum = 0;

        if (fileTree.files.size() == 0) {
            return 0;
        }
        int returnva = 0;

        if (!fileTree.children.isEmpty()) {
            for (Map.Entry<String, FileTree> entry : fileTree.children.entrySet()) {
//                System.out.println("dfs for:" + entry.getKey());
                returnva = dfs(entry.getValue(), sum);
                System.out.println("Return val: " + returnva);
            }
//            return 0;
        }

        for (Map.Entry<String, Integer> entry : fileTree.files.entrySet()) {
            sum += entry.getValue();
        }

        sum += returnva;
        sum += childSize2;
        System.out.println("sum for: " + fileTree.name + " : " + sum);

        if (sum < 100000) {
            System.out.println("Adding sum " + fileTree.name);
            totalSum += sum;
        }

        return sum;
    }

    public static int dfs(FileTree fileTree) {
        //time to do DFS lol

        if (fileTree.files.size() == 0) {
            return 0;
        }
        if (fileTree.children.size() == 0) {
            return 0;
        }

        for (Map.Entry<String, FileTree> entry : fileTree.children.entrySet()) {
            dfs(entry.getValue());
        }

        int sum = 0;
        for (Map.Entry<String, Integer> entry : fileTree.files.entrySet()) {
            sum += entry.getValue();
        }

        if (sum < 100000) {
            System.out.println("Adding sum " + fileTree.name);
            totalSum += sum;
        }

        return 0;
    }


    public static class FileTree {
        public String name = "";
        public HashMap<String, FileTree> children = new HashMap<>();
        public HashMap<String, Integer> files = new HashMap<>();

        FileTree(String name) {
            this.name = name;
        }
    }


}


