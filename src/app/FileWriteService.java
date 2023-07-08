package app;

import utils.Constants;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteService {

    public String handleFile(String myText, String fileName) {
        try (FileOutputStream fout = new FileOutputStream(Constants.BASE_PATH_IN + fileName)) {
            byte[] byteArr = myText.getBytes();
            fout.write(byteArr);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return "Success!";
    }
}
