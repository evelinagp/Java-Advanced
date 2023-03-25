package SetsAndMapsAdvanced3.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountRealNumbersLab04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbers = new LinkedHashMap<>();
// Ако го няма ключа - запиши + стойност 0 или добави към ключа дадената стойност
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble)
                .forEach(n -> {
                    numbers.putIfAbsent(n, 0);
                    numbers.put(n, numbers.get(n) + 1);
                });
        for (Map.Entry<Double, Integer>  entry : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

//        String output = numbers.entrySet().stream().map(entry -> String.format("%.1f -> %d", entry.getKey(), entry.getValue()))
//                .collect(Collectors.joining(System.lineSeparator()));
//        System.out.println(output);
    }
}
