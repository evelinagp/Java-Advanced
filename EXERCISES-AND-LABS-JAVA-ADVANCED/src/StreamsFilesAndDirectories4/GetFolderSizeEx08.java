package StreamsFilesAndDirectories4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class GetFolderSizeEx08 {

    public static void main(String[] args) throws IOException {

        String path = ("C:\\Users\\User\\Desktop\\JAVA ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        File folder = new File(path);

        long size = 0;
        for (File file : folder.listFiles()) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);
    }
}

