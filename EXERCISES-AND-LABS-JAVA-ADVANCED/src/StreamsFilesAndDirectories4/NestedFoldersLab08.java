package StreamsFilesAndDirectories4;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class NestedFoldersLab08 {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources");

        ArrayDeque<File> files = new ArrayDeque<>();

        files.offer(file);

        PrintStream printStream = new PrintStream("nested-out.txt");

        while (!files.isEmpty()) {
            File innerFile = files.poll();
//           printStream.println(innerFile.getName());
            for (File f : innerFile.listFiles()) {
                if (f.isDirectory()) {
                    files.offer(f);
                } else {
                    printStream.println(f.getName());
                }
            }
            printStream.printf("[%d]", innerFile.length());
        }
    }
}
