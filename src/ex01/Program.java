package ex01;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Program {
    private static FileHandler[] files;
    private static List<String> dictionaryList = new ArrayList<>();
    private static int[][] vectors = new int[2][];

    public static void main(String[] args) {
        try {
            if (args.length != 2)
                throw new RuntimeException("You should write 2 name of files.");

            FileHandler[] files = {new FileHandler(args[0]), new FileHandler(args[1])};
            Set<String> dictionarySet = new HashSet<>();
            for (FileHandler file : files) {
                dictionarySet.addAll(file.getWords());
            }
            downloadDictInFile(dictionarySet);

            dictionaryList = dictionarySet.stream().toList();
            for (int i = 0; i < files.length; i++) {
                vectors[i] = files[i].findVector(dictionaryList);
            }
            System.out.println("Similarity = " + floor(Calculator.calculateSimilarity(vectors) * 100) / 100);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int getDictSize(){
        return dictionaryList.size();
    }

    private static void downloadDictInFile(Set<String> dictionary) throws IOException {
        File file = new File("ex01/dictionary.txt");
        file.createNewFile();
        if (file.exists()) {
            BufferedWriter dictWriter = new BufferedWriter(new FileWriter(file));
            dictWriter.write(dictionary.toString());
            dictWriter.close();
        } else {
            throw new IOException("Can`t open dictionary file");
        }
    }

}
