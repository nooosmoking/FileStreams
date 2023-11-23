package ex00;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ResultWriter {
    public static void write(String typeFile) {
        File file = new File("ex00/result.txt");
        boolean succsess = false;
        try {
            succsess = file.createNewFile();
        } catch (IOException ex) {
            System.err.println("Can`t create result file");
            System.exit(-1);
        }
        if (succsess || file.exists()) {
            try {
                FileOutputStream output = new FileOutputStream(file, true);
                output.write((typeFile + "\n").getBytes());
                output.close();
            } catch (Exception ex) {
                System.err.println("Can`t open result file");
                System.exit(-1);
            }
        } else {
            System.err.println("Can`t create result file");
            System.exit(-1);
        }
    }
}
