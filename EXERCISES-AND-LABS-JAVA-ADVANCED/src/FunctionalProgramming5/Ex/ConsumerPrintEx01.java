package FunctionalProgramming5.Ex;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrintEx01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String[]> printName = array -> {
            for (String name : names) {
                System.out.println(name);
            }
        };
        printName.accept(names);
    }
}
