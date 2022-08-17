package StreamsFilesAndDirectories4;

import java.io.*;

public class ListFilesLab07 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File [] files = file.listFiles();
        for (File f : files) {
            if (!f.isDirectory()){
                System.out.printf("%s: [%d]%n", f.getName(), f.length());
            }
        }
    }
}
