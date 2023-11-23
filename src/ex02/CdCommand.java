package ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommand implements Command{
    @Override
    public void run(String answerStr) throws Exception {
        String[] splitAnswer = answerStr.split("\\s+");
        if (splitAnswer.length != 2)
            throw new Exception();
        Path destination = Program.currentPath.resolve(splitAnswer[1]).toRealPath();
        if(!Files.isDirectory(destination) || !Files.exists(destination)) {
            throw new Exception();
        }
        Program.currentPath = destination;
    }
}
