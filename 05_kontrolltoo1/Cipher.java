import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cipher {
    private int shift;

    public Cipher(int shift) {
        this.shift = shift;
    }

    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char shiftedChar = (char) ('A' + (ch - 'A' + shift) % 26);
                    result.append(shiftedChar);
                } else {
                    char shiftedChar = (char) ('a' + (ch - 'a' + shift) % 26);
                    result.append(shiftedChar);
                }
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char shiftedChar = (char) ('Z' - ('Z' - ch + shift) % 26);
                    result.append(shiftedChar);
                } else {
                    char shiftedChar = (char) ('z' - ('z' - ch + shift) % 26);
                    result.append(shiftedChar);
                }
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try {
            Scanner scanner = new Scanner(inputFile);
            int shift = scanner.nextInt();
            scanner.nextLine();
            String text = scanner.nextLine();
            Cipher cipher = new Cipher(shift);
            String result = cipher.encrypt(text);
            FileWriter writer = new FileWriter(outputFile);
            writer.write(result);
            writer.close();
            System.out.println("Tekst on šifreeritud ja salvestatud faili output.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Input faili ei leitud.");
        } catch (IOException e) {
            System.out.println("Error kirjutades faili.");
        }
    }
}
