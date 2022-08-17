package IteratorsAndComparators9.IteratorsAndComparatorsListyIteratorEx02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            switch (input) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.HasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}

