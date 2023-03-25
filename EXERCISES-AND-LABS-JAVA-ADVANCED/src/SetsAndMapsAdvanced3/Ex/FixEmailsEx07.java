package SetsAndMapsAdvanced3.Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmailsEx07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsData = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
//            първи начин
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
//                втори начин - не много правилен!
//            if (!email.contains("us") && !email.contains("uk") && !email.contains("com")) {
                emailsData.put(name, email);
            }
            name = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : emailsData.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
