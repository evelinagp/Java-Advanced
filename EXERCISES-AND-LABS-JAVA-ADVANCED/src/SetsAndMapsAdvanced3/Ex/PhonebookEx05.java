package SetsAndMapsAdvanced3.Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhonebookEx05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phoneBook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phoneBook.put(name, number);
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            if (phoneBook.containsKey(name)) {
                System.out.println(name + " -> " + phoneBook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scanner.nextLine();
        }
    }
}
