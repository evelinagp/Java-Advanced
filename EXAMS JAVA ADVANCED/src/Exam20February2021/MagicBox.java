package Exam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);


        int claimedItemsSum = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstItem = firstBoxQueue.peek();
            int secondItem = secondBoxStack.pop();

            int sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                claimedItemsSum += sum;
                firstBoxQueue.poll();
            } else {
                firstBoxQueue.offer(secondItem);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItemsSum >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItemsSum);
        } else {
            System.out.println("Poor prey... Value: " + claimedItemsSum);
        }
    }
}
