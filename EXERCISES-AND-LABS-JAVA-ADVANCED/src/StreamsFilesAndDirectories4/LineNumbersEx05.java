package StreamsFilesAndDirectories4;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbersEx05 {

    public static int row = 1;

    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");

        List<String> lines = Files.readAllLines(path);

        PrintWriter writer = new PrintWriter("outputLines.txt");
        lines.forEach(line -> writer.println(row++ + ". " + line));
//        ВАРИАНТ 2
//        int row = 1;
//        for (String line : lines) {
//            writer.println(row++ + ". " + line);
//        }
        writer.close();
    }
}

