package StreamsFilesAndDirectories4.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class WriteToFileLab02 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);
        String table = ",.!?";

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (!String.valueOf(symbol).contains(table)) {
                    System.out.print(symbol);
                }
            }
            System.out.println();
        }
    }
}
