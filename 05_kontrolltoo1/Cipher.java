import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cipher {
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        // Loeme sisse sisendi failist
        String input = readFromFile(INPUT_FILE);

        // Teeme šifreerimise
        String encrypted = encrypt(input, 1);

        // Salvestame tulemuse väljundfaili
        saveToFile(OUTPUT_FILE, encrypted);

        // Dešifreerime šifreeritud sõnumi
        String decrypted = decrypt(encrypted, 1);

        // Väljastame dešifreeritud sõnumi
        System.out.println("Decrypted message: " + decrypted);
    }

    public static String encrypt(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (((c - base + shift) % ALPHABET_SIZE + ALPHABET_SIZE) % ALPHABET_SIZE + base);
            }
            result.append(c);
        }
        return result.toString();
    }

    public static String decrypt(String message, int shift) {
        return encrypt(message, ALPHABET_SIZE - shift);
    }

    private static String readFromFile(String fileName) {
        File file = new File("src/" + fileName);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return result.toString().trim();
    }

    private static void saveToFile(String fileName, String content) {
        try (PrintWriter writer = new PrintWriter("src/" + fileName)) {
            writer.print(content);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
