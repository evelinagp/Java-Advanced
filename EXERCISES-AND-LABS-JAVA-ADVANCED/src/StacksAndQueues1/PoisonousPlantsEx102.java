package StacksAndQueues1;

import java.util.*;

public class PoisonousPlantsEx102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queuePrint = new ArrayDeque<>();
        ArrayDeque<Integer> queueDie = new ArrayDeque<>();

        boolean isNextBigger = false;
        int countDays = 0;
        for (int i = 0; i < n; i++) {
            int currentNumber = numbers[i];
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                int nextNumber = numbers[j];
                if (currentNumber != numbers[0] && currentNumber < nextNumber) {
                    isNextBigger = true;
                    queuePrint.offer(currentNumber);
                    queueDie.offer(nextNumber);
                } else {
                    isNextBigger = false;
                    queuePrint.offer(currentNumber);
                    break;
                }
            }
        }
        while (isNextBigger) {
            countDays++;
        }
    }
}