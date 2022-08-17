package IteratorsAndComparators9.IteratorsAndComparatorsStackIteratorEx03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("[, ]+");
            switch (tokens[0]) {
                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        stack.push(Integer.parseInt(tokens[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println("No elements");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 1; i <= 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
