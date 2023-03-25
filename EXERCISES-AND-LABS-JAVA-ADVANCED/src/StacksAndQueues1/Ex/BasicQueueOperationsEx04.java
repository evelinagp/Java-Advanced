package StacksAndQueues1.Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperationsEx04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbersInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = numbersInput[0];
        int s = numbersInput[1];
        int x = numbersInput[2];


        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            int number = numbers[i];
            numbersQueue.offer(number);
        }
        for (int i = 0; i < s; i++) {
            if (!numbersQueue.isEmpty()) {
                numbersQueue.poll();
            }
        }
        if (numbersQueue.isEmpty()) {
            System.out.println("0");
        } else if (numbersQueue.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numbersQueue));
        }
    }
}

