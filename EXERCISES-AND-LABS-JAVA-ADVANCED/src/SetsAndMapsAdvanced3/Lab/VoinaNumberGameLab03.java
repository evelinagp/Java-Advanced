package SetsAndMapsAdvanced3.Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGameLab03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDesk = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDesk = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0 && !firstDesk.isEmpty() && !secondDesk.isEmpty()) {

            Integer firstCard = firstDesk.iterator().next();
            firstDesk.remove(firstCard);
            Integer secondCard = secondDesk.iterator().next();
            secondDesk.remove(secondCard);
            if (firstCard > secondCard) {
                firstDesk.add(firstCard);
                firstDesk.add(secondCard);
            } else {
                secondDesk.add(firstCard);
                secondDesk.add(secondCard);
            }
            if (firstDesk.isEmpty() || secondDesk.isEmpty()){
                break;
            }
        }
        if (firstDesk.size() < secondDesk.size()) {
            System.out.println("Second player win!");
        } else if (firstDesk.size() > secondDesk.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
