package FunctionalProgramming5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWordsLab03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate <String> startsWithCapitalLetter = str -> Character.isUpperCase(str.charAt(0));

        String[] words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(startsWithCapitalLetter).toArray(String[]::new);

        System.out.println(words.length);

        Arrays.stream(words).forEach(System.out::println);
    }
}
