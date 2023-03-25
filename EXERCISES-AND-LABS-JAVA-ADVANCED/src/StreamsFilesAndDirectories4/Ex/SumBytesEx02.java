package StreamsFilesAndDirectories4.Ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SumBytesEx02 {


    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);

        } catch (NoSuchFileException e) {
            System.out.println("There is no such file on this path");
        }catch (IOException io){
            System.out.println("Another error with reading file");
        }
        int sumLines = 0;
        for (String line : lines) {
            sumLines += getSumAsciiLine(line);
        }
        System.out.println(sumLines);
    }

    private static int getSumAsciiLine(String line) {
        int sum = 0;
        for (char symbol: line.toCharArray()) {
            sum += symbol;
        }
        return (sum);
    }
}
