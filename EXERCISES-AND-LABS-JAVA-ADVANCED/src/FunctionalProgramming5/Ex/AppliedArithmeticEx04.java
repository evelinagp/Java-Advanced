package FunctionalProgramming5.Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmeticEx04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], int[]> add = array -> Arrays.stream(array).map(e -> e += 1).toArray();

        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(e -> e *= 2).toArray();

        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(e -> e -= 1).toArray();

        Consumer<int[]> print = array -> Arrays.stream(array).forEach(e -> System.out.print(e + " "));

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers );
                    System.out.println();
                    break;
            }
            command= scanner.nextLine();
        }

    }
}
