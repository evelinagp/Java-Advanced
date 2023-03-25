package SetsAndMapsAdvanced3.Ex;

import java.util.*;

public class UniqueUsernamesEx01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> namesSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            namesSet.add(name);
        }
        for (String name : namesSet) {
            System.out.println(name);

//            compoundsSet.foreach (e -> System.out.println(e + " ");
        }
    }
}

