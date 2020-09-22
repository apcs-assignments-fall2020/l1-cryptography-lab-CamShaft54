import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        int[] keys = key.chars().toArray();
        String result = "";
        int j = 0;
        for (int i = 0; i < message.length(); i++) {
            int cur_key = keys[j % keys.length] - 65;
            j++;
            char cur_char = message.charAt(i);
            if (cur_char >= 65 && cur_char <= 90) {
                result += (char) ((cur_char - 65 + cur_key) % 26 + 65);
            } else if (cur_char >= 97 && cur_char <= 122) {
                result += (char) ((cur_char - 97 + cur_key) % 26 + 97);
            } else {
                result += cur_char;
                j--;
            }
        }
        return result;
    }

    public static String decryptVigenere(String message, String key) {
        int[] keys = key.chars().toArray();
        String result = "";
        int j = 0;
        for (int i = 0; i < message.length(); i++) {
            int cur_key = keys[j % keys.length] - 65;
            j++;
            char cur_char = message.charAt(i);
            if (cur_char >= 65 && cur_char <= 90) {
                result += (char) ((cur_char - 65 + 26 - cur_key) % 26 + 65);
            } else if (cur_char >= 97 && cur_char <= 122) {
                result += (char) ((cur_char - 97 + 26 - cur_key) % 26 + 97);
            } else {
                result += cur_char;
                j--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
