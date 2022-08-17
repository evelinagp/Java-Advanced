package Exam14April2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BouquetsEx01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt)
                .forEach(tulipsStack::push);
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt)
                .forEach(daffodilsQueue::offer);

//        boolean is5BouquetsMade = false;
        int storedFlowers = 0;
        int bouquetsCount = 0;
        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            if (tulipsStack.peek() + daffodilsQueue.peek() == 15) {
                tulipsStack.pop();
                daffodilsQueue.poll();
                bouquetsCount++;
            } else {
                if (tulipsStack.peek() + daffodilsQueue.peek() > 15) {
                    int numberForDecrease = tulipsStack.pop();
                    tulipsStack.push(numberForDecrease - 2);
//                , keep decreasing the value of the tulips by 2.
                } else if (tulipsStack.peek() + daffodilsQueue.peek() < 15) {
                    storedFlowers += tulipsStack.pop() + daffodilsQueue.poll();
//                have to store them for later and remove them.
                }
            }
         }
        if (storedFlowers >= 15) {
            bouquetsCount += storedFlowers / 15;
        }
        if (bouquetsCount >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquetsCount);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetsCount);
        }
    }
}
