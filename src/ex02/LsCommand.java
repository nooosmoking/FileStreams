package ex02;

import java.io.IOException;
import java.nio.file.*;

public class LsCommand implements Command{
    @Override
    public void run(String answerStr) throws Exception {
        if (!answerStr.equals("ls"))
            throw new Exception();
        DirectoryStream<Path> dirStream = Files.newDirectoryStream(Program.currentPath);
        for (Path child: dirStream) {
            System.out.println(child.getFileName() + " " + Files.size(child)/1024 + " KB");
        }
    }
}
