package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfixEx09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> queueNumbers = new ArrayDeque<>();
        ArrayDeque<String> stackOperands = new ArrayDeque<>();

        String[] tokens = input.split("\\s+");
        for (String token : tokens) {
            char currentChar = token.charAt(0);
            if (Character.isDigit(currentChar) || Character.isAlphabetic(currentChar)) {
                queueNumbers.offer(token);
            } else if (currentChar == ('+') || currentChar == ('-') || currentChar == ('*') || currentChar == ('/')) {
//                queueNumbers.offer((char) (tokens[i + 1].charAt(0)));
//                queueNumbers.offer((currentChar));
            } else {
                if (currentChar == ('(')) {
                    int lastIndex = input.indexOf(")");
                    String substringInBrackets = input.substring(input.indexOf(currentChar, lastIndex));
                }
//                    if (Character.isDigit(substringInBrackets.charAt(i)) || Character.isAlphabetic(substringInBrackets.charAt(i))) {
//                        queue.offer(currentChar);
//                    } else if (substringInBrackets.contains("+")) {
//                        queue.offerFirst("+");
//                    } else if (substringInBrackets.contains("-")) {
//                        queue.offerFirst("-");
//                    } else if (substringInBrackets.contains("*")) {
//                        queue.offerFirst("*");
//                    } else if (substringInBrackets.contains("/")) {
//                        queue.offerFirst("/");
//                    }

//                    } else {
//                    queue.offer(currentChar);
//                    }
//                }
//            }
//        }
//
//        while (!queueNumbers.isEmpty()) {
//            System.out.println(queueNumbers);
//        }
            }
        }
    }
}








