package SetsAndMapsAdvanced3;

import java.util.*;

public class PeriodicTableEx03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> compoundsSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] compounds = scanner.nextLine().split("\\s+");
//            начин 1
            compoundsSet.addAll(Arrays.asList(compounds));
//            начин 2
//            Collections.addAll(compoundsSet, compounds);
//            начин 3
//            for (String compound : compounds) {
//                compoundsSet.add(compound);
        }
        for (String element : compoundsSet) {
            System.out.print(element + " ");

//            compoundsSet.foreach (e -> System.out.println(e + " ");
        }
    }
}
