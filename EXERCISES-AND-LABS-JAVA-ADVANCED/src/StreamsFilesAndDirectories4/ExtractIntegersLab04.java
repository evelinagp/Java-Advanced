package StreamsFilesAndDirectories4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExtractIntegersLab04 {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
