package FunctionalProgramming5.Ex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicatesEx09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
//        приема лист и число
        BiFunction<List<Integer>, Integer, Boolean> predicate = ((list, number) -> {
            for (Integer numInList : list) {
                if (number % numInList != 0) {
                    return false;
                }
            }
            return true;
        });

//        проверка дали дадено число се дели на всички числа от листа
        for (int number = 1; number <= n; number++) {
            if (predicate.apply(numbers, number)) {
                System.out.print(number + " ");
            }
        }
    }
}
