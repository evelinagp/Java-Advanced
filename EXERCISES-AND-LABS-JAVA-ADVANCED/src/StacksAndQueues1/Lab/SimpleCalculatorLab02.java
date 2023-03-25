package StacksAndQueues1.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculatorLab02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (Character.isDigit(token.charAt(0))) {
                numbers.push(Integer.parseInt(token));
            } else {
                int rightOperand = Integer.parseInt(tokens[++i]);
                int leftOperand = numbers.peek();
                numbers.push(rightOperand);
                if (token.equals("+")) {
                    result = leftOperand + rightOperand;
                } else {
                    result = leftOperand - rightOperand;
                }
                numbers.push(result);
            }
        }
        System.out.println(numbers.pop());
    }
}

