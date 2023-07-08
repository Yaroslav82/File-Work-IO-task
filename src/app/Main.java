package app;

import utils.Constants;

import java.util.Scanner;

public class Main {

    private final static String DEFAULT_INPUT = "Input file name: ";
    private final static String SELECT_MODE_MESSAGE = "Select the file operation mode: write (w) or read (r): ";
    private final static String ENTER_TEXT_MESSAGE = "Enter the text to be written to the file: ";

    public static void main(String[] args) {
        getOutput(selectMode(getFileName()));
    }

    private static String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(DEFAULT_INPUT);
        return scanner.nextLine();
    }

    private static String readFileData(String file) {
        return new FileReadService().readFile(file);
    }

    private static String writeFileData(String file, String message) {
        return new FileWriteService().handleFile(file, message);
    }

    private static String selectMode(String file) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(SELECT_MODE_MESSAGE);
        String mode = scanner.nextLine();

        if (mode.equals(Constants.WRITING_MODE)) {
            System.out.print(ENTER_TEXT_MESSAGE);
            String text = scanner.nextLine();
            return writeFileData(file, text);
        } else if (mode.equals(Constants.READING_MODE)) {
            return readFileData(file);
        } else {
            return Constants.UNKNOWN_MODE;
        }
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
