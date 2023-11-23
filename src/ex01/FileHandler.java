package ex01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler extends BufferedReader {
    private ArrayList<String> fileWords = new ArrayList<>();

    public FileHandler(String in) throws IOException {
        super(new FileReader(in));
        String str = this.readLine();
        while (str != null) {
            String[] lineWords = str.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
            fileWords.addAll(List.of(lineWords));
            str = this.readLine();
        }
        this.close();
    }

    public ArrayList<String> getWords(){
        return fileWords;
    }

    public int[] findVector(List<String> dictionaryList){
        int[] vector = new int[dictionaryList.size()];
            for (String word : fileWords
            ) {
                vector[dictionaryList.indexOf(word)]++;
            }
        return vector;
    }
}
