package StreamsFilesAndDirectories4;

import java.io.FileInputStream;
import java.io.IOException;
//import java.io.PrintStream;

public class CopyBytesLab03 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        FileInputStream inputStream = new FileInputStream(path);

        int nextByte = inputStream.read();

//        PrintStream printStream = new PrintStream("copy-bits-out.txt");

        while (nextByte != -1) {
            if (nextByte == ' ') {
                System.out.print((char) nextByte);
            } else if (nextByte == 10) {
                System.out.println();
            } else {
                System.out.print(nextByte);
            }
            nextByte = inputStream.read();
        }
    }
}
