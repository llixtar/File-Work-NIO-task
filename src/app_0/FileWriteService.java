package app_0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteService {

    public String writeFile(String path, String text) {
        String res = "";
        if (createFile(path)) {
            try {
                Files.writeString(Paths.get(path), text);
            } catch (IOException e) {
                return e.getMessage();
            }
            res = "Файл: " + path + " успішно створено і записано!";
        }

        return res;
    }

    private boolean createFile(String strPath) {
        try {
            Files.createFile(Path.of(strPath));
            return true;
        } catch (IOException e) {

            return false;
        }

    }
}
