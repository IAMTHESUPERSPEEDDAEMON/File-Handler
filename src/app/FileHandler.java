package app;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "files/";

    public String writeFile(String fileName, String fileContent) {
        try(FileWriter fw = new FileWriter( BASE_PATH+ fileName + ".txt")) {
            fw.write(fileContent);
            return "Success.";
        } catch (Exception e) {
            if (new File(BASE_PATH).mkdir()) {
                try (FileWriter fw = new FileWriter(BASE_PATH + fileName + ".txt")) {
                    fw.write(fileContent);
                    return "Success after creating directory.";
                } catch (Exception innerE) {
                    return "Failed to write file: " + innerE.getMessage();
                }
            }
            return "Failed to create directory and write file";
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int sym;
            StringBuilder stringBuilder = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}

