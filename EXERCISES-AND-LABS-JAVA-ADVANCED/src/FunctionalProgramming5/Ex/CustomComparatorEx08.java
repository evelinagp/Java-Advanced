package FunctionalProgramming5.Ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparatorEx08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

//Ако първото е четно, а второто нечетно -> (първо, второ);
//        първото е нечетно, а второто е четно -> -1 (второ, първо)

        Comparator<Integer> comparator = (firstNumber, secondNumber) -> {
            if (firstNumber % 2 == 0 && secondNumber % 2 != 0){
                return -1;
            }else if (firstNumber % 2 != 0 && secondNumber % 2 == 0) {
                return 1;
            }else if ((firstNumber % 2 == 0 && secondNumber % 2 == 0) || (firstNumber % 2 != 0 && secondNumber % 2 != 0)) {
                if (firstNumber <= secondNumber){
                    return -1;
                }else {
                    return 1;
                }
            }
            return 0;
        };
        numbers.sort(comparator);

        numbers.forEach(e-> System.out.print(e + " "));
    }
}
