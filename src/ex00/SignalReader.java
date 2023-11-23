package ex00;

import java.io.*;
import java.util.*;

public class SignalReader {
    public static Map<String, String> read() {
        Scanner in = null;
        Map<String, String> signalMap = new HashMap<>();
        try {
            File file = new File("./ex00/signal.txt");
            in = new Scanner(file);
        } catch (Exception error) {
            System.err.println("File not found");
            System.exit(-1);
        }
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] separateLine = line.split(", ");
            signalMap.put(separateLine[0], separateLine[1]);
        }
        in.close();
        return signalMap;
    }
}
