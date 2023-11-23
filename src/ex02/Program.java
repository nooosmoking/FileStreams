package ex02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    private static Map<String, Command> commandMap;
    protected static Path currentPath;
    public static void main(String[] args) {
        checkArgPath(args);
        System.out.println(currentPath);
        createMap();
        Scanner in = new Scanner(System.in);
        String answerStr = in.nextLine().trim();
        while(!answerStr.equals("exit")) {
            doCommand(answerStr);
            answerStr = in.nextLine().trim();
        }
    }

    public static void checkArgPath(String[] args) {
        try {
            if (args.length != 1)
                throw new RuntimeException("Incorrect count of arguments!");
            String[] argWords = args[0].split("=");
            if (argWords.length != 2 || !argWords[0].equals("--current-folder"))
                throw new RuntimeException("Incorrect argument!");
            currentPath = Paths.get(argWords[1]);
            if (!currentPath.isAbsolute())
                throw new RuntimeException("Path isn`t absolute!");
            if(!Files.isDirectory(currentPath) || !Files.exists(currentPath)){
                throw new RuntimeException("It`s not a directory in argument!");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }

    private static void createMap(){
        commandMap = new HashMap<>();
        commandMap.put("ls", new LsCommand());
        commandMap.put("cd", new CdCommand());
        commandMap.put("mv", new MvCommand());
    }

    private static void doCommand(String answerStr) {
        String command = answerStr.split(" ")[0];
        try {
            commandMap.get(command).run(answerStr);
        } catch (Exception ex) {
            System.out.println("Incorrect command!");
        }
    }
}

