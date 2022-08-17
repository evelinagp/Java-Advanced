package SetsAndMapsAdvanced3;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElementsEx02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }
//        {1 3 5 7 }
//        {3 4 5 }
        firstSet.retainAll(secondSet);
//        firstSet - дублираните елементи се запазват само в първият сет, а останалите се изтриват!
        for (Integer number : firstSet) {
            System.out.print(number + " ");
        }
    }
}

