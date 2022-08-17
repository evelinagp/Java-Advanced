package StreamsFilesAndDirectories4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class allCapitalSEx03 {
    public static void main(String[] args) {


    Path path = Path.of("C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
            "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

    List<String> lines = new ArrayList<>();


        try {
            lines = Files.readAllLines(path);
        } catch (
                IOException io) {
            System.out.println("Another error with reading file");
//            print data
        }
        try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
                for (String line : lines) {
                    writer.write(line.toUpperCase(Locale.ROOT));
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


