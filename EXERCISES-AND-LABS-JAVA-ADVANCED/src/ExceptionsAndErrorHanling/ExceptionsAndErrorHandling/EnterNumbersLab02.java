package ExceptionsAndErrorHanling.ExceptionsAndErrorHandling;

import java.util.Scanner;
import java.util.stream.IntStream;

public class EnterNumbersLab02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String start = scanner.nextLine();
            String end = scanner.nextLine();
            try {
                printNumberRange(start, end);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printNumberRange(String start, String end) {
        int s;
        int e;
        try {
            s = Integer.parseInt(start);
            e = Integer.parseInt(end);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid input, please enter new range.", ex);
        }
        if (!(1 < s && s < e && e < 100)){
            throw new IllegalArgumentException("Invalid input, please enter new range.");
        }
        IntStream.rangeClosed(s, e).forEach(System.out::println);
    }

    public static double sqrt(Scanner scanner) {
        String str = scanner.nextLine();
        for (char symbol : str.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                throw new NumberFormatException("Invalid number!");
            }
        }
        return Math.sqrt(Integer.parseInt(str));
    }
}

