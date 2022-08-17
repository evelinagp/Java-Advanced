package FunctionalProgramming5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExcludeEx05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(list);

        Predicate <Integer> checkDivision = number -> number % n ==0;
        list.removeIf(checkDivision);

        Consumer <List<Integer>> print = numbers -> numbers.forEach(e -> System.out.print(e + " "));
        print.accept(list);
    }
}
