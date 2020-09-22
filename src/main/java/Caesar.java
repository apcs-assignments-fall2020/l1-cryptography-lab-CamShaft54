import java.util.Arrays;
import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        return Arrays.toString(message.chars().mapToObj(c -> (c >= 65 && c <= 90) ? (char) ((c - 65 + 3) % 26 + 65) : (c >= 97 && c <= 122) ? (char) ((c - 97 + 3) % 26 + 97) : (char) c).toArray()).replace("[", "").replace(", ","").replace("]", "");
    }

    public static String decryptCaesar(String message) {
        return Arrays.toString(message.chars().mapToObj(c -> (c >= 65 && c <= 90) ? (char) ((c - 65 + 26 - 3) % 26 + 65) : (c >= 97 && c <= 122) ? (char) ((c - 97 + 26 - 3) % 26 + 97) : (char) c).toArray()).replace("[", "").replace(", ","").replace("]", "");
    }

    public static String encryptCaesarKey(String message, int key) {
        return Arrays.toString(message.chars().mapToObj(c -> (c >= 65 && c <= 90) ? (char) ((c - 65 + key) % 26 + 65) : (c >= 97 && c <= 122) ? (char) ((c - 97 + key) % 26 + 97) : (char) c).toArray()).replace("[", "").replace(", ","").replace("]", "");
    }

    public static String decryptCaesarKey(String message, int key) {
        return Arrays.toString(message.chars().mapToObj(c -> (c >= 65 && c <= 90) ? (char) ((c - 65 + 26 - (key % 26)) % 26 + 65) : (c >= 97 && c <= 122) ? (char) ((c - 97 + 26 - key) % 26 + 97) : (char) c).toArray()).replace("[", "").replace(", ","").replace("]", "");
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
