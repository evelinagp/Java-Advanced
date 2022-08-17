package Exam19August2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class FlowerWreaths19August2020 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt)
                .forEach(liliesStack::push);
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt)
                .forEach(rosesQueue::offer);

//        boolean is5BouquetsMade = false;
        int storedFlowers = 0;
        int wreathsCount  = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            if (liliesStack.peek() + rosesQueue.peek() == 15) {
                liliesStack.pop();
                rosesQueue.poll();
                wreathsCount ++;
            } else {
                if (liliesStack.peek() + rosesQueue.peek() > 15) {
                    int numberForDecrease = liliesStack.pop();
                    liliesStack.push(numberForDecrease - 2);
//                , keep decreasing the value of the tulips by 2.
                } else if (liliesStack.peek() + rosesQueue.peek() < 15) {
                    storedFlowers += liliesStack.pop() + rosesQueue.poll();
//                have to store them for later and remove them.
                }
            }
        }
        if (storedFlowers >= 15) {
            wreathsCount  += storedFlowers / 15;
        }
        if (wreathsCount  >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreathsCount );
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathsCount );
        }
    }
}