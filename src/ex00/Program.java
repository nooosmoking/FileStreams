package ex00;

import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter filename:");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = line.trim();
        while (!line.equals("42")) {
            System.out.println("PROCESSED");
            String typeFile = SignalFinder.findType(line);
            if (typeFile != null) ResultWriter.write(typeFile);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Enter filename:");
            line = in.nextLine();
        }
        in.close();
    }
}
