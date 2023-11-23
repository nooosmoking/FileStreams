package ex02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MvCommand implements Command{
    @Override
    public void run(String answerStr) throws Exception {
        String[] splitAnswer = answerStr.split("\\s+");
        if (splitAnswer.length != 3)
            throw new Exception();
        Path object = Program.currentPath.resolve(splitAnswer[1]).toRealPath();
        Path destination = Program.currentPath.resolve(splitAnswer[2]).toRealPath();
        if(!Files.exists(object) || !Files.exists(destination) || !Files.isDirectory(destination)) {
            throw new Exception();
        }
        Files.move(object, destination.resolve(splitAnswer[1]));    }
}
