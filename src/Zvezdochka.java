import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Zvezdochka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к входному файлу: ");
        String inputFilePath = scanner.nextLine();
        String validOutputFilePath = inputFilePath.replace(".txt", "valid.txt");
        String invalidOutputFilePath = inputFilePath.replace(".txt", "invalid.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             FileWriter validWriter = new FileWriter(validOutputFilePath);
             FileWriter invalidWriter = new FileWriter(invalidOutputFilePath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidDocumentNumber(line)) {
                    validWriter.write(line + "\n");
                } else {
                    invalidWriter.write(line + " - номер документа не соответствует требованиям\n");
                }
            }

            System.out.println("Валидные номера документов сохранены в файле " + validOutputFilePath);
            System.out.println("Невалидные номера документов сохранены в файле " + invalidOutputFilePath);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static boolean isValidDocumentNumber(String documentNumber) {
        return documentNumber.length() == 15 &&
                (documentNumber.startsWith("docnum") || documentNumber.startsWith("contract"));
    }
}