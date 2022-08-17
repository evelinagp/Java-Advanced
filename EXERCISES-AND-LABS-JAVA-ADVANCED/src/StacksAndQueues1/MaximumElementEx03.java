package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElementEx03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(element -> Integer.parseInt(element)).toArray();

            int command = line[0];

            switch (command) {
                case 1:
                    int number = line[1];
                    numbersStack.push(number);
                    break;
                case 2:
                    if (!numbersStack.isEmpty()) {
                        numbersStack.pop();
                    }
                    break;
                case 3:
                    Integer maxNumber = Collections.max(numbersStack);
                    System.out.println(maxNumber);
                    break;
            }
        }
    }
}


