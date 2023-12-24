package task1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("task1/Romeo And Juliet.txt");
        Scanner scanner = new Scanner(inputFile);
        String longestWord = "";
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        scanner.close();
        File outputFile = new File("output.txt");
        FileWriter writer = new FileWriter(outputFile);
        writer.write(longestWord);
        writer.close();
    }
}
