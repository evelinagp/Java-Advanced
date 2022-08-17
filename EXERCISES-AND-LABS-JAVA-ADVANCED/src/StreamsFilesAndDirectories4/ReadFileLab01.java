package StreamsFilesAndDirectories4;

import java.io.FileInputStream;
import java.io.IOException;
//import java.util.Scanner;

public class ReadFileLab01 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        int oneByte = inputStream.read();
        while (oneByte >= 0) {
            System.out.printf("%s ", Integer.toBinaryString(oneByte));
            oneByte = inputStream.read();
        }
    }
}
