package StacksAndQueues1.Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperationsEx02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        ArrayDeque<Integer> stack1 = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt).forEach(e -> push(e));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] numbersCommands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int numToAdd = numbersCommands[0];
        int numToPop = numbersCommands[1];
        int numContains = numbersCommands[2];


        int[] numbersToManipulate = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int number : numbersToManipulate) {
            stack.push(number);
        }

        while (numToPop-- > 0 && !stack.isEmpty()) {
            stack.pop();
//            numToPop--;
        }
        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            if (stack.contains(numContains)) {
                System.out.println("true");
            } else {

                //get current min element
//            int minElement = getMinElement(stack);
                Integer minElement = Collections.min(stack);
                System.out.println(minElement);
            }
        }
    }

    private static int getMinElement(ArrayDeque<Integer> stack) {
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int currentElement = stack.pop();
            if (currentElement < min) {
                min = currentElement;
            }
        }
        return min;
    }
}

