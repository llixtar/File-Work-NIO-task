package app_0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadService {

    public   String readFromFile(String strPath) {
        try {
            return Files.readString(
                    Path.of(strPath // <- Конвертація String у Path
                    ));
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}
