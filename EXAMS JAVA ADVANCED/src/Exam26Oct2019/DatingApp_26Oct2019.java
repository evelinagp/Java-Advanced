package Exam26Oct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp_26Oct2019 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(maleStack::push);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(femaleQueue::offer);
        int matchesCount = 0;
        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            if (maleStack.peek() % 25 == 0 && maleStack.peek() > 0) {
                maleStack.pop();
                maleStack.pop();
                continue;
            } else if (femaleQueue.peek() % 25 == 0 && femaleQueue.peek() > 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }
            if (maleStack.peek() <= 0) {
                maleStack.pop();
                continue;
            } else if (femaleQueue.peek() <= 0) {
                femaleQueue.poll();
                continue;
            }
            if (maleStack.peek().equals(femaleQueue.peek())) {
                maleStack.pop();
                femaleQueue.poll();
                matchesCount++;
            } else {
                femaleQueue.poll();
                int currentNumber = maleStack.pop();
                maleStack.push(currentNumber - 2);
            }
//            if (maleStack.size() == 0 || femaleQueue.size() == 0) {
//                break;
//            }
        }
        System.out.println("Matches: " + matchesCount);
        if (maleStack.size() == 0) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.print(maleStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }

        if (femaleQueue.size() == 0) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.print(femaleQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
    }
}

