package app;

import utils.Constants;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteService {
    private final static String SUCCESS = "Success!";

    public String handleFile(String fileName, String text) {
        try (FileOutputStream fout = new FileOutputStream(Constants.BASE_PATH_IN + fileName)) {
            byte[] byteArr = text.getBytes();
            fout.write(byteArr);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return SUCCESS;
    }
}
