package StreamsFilesAndDirectories4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;


public class SortLinesLab06 {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> strings = Files.readAllLines(path);

        Collections.sort(strings);

        Files.write(Paths.get("files-demo.txt"), strings);

    }
}
