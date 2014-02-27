package filepath;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilePath {

    public static void main(String[] args) throws IOException {
       String dirString = "/Users/benjamintauber/Desktop";
       Path dirPath = Paths.get(dirString);
       if(Files.exists(dirPath) && Files.isDirectory(dirPath)){
           System.out.println("Directory: " + dirPath.toAbsolutePath());
           System.out.println("Files: ");
           DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath);
           for (Path p : dirStream){
               System.out.println(p.getFileName());
           }
       }
    }       
}
