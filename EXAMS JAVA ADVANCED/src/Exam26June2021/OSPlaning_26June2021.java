package Exam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning_26June2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(tasksStack::push);

        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(threadQueue::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        int tread = 0;
        while (!tasksStack.isEmpty() && !threadQueue.isEmpty()) {
            if (tasksStack.peek() == taskToKill) {
                tread += threadQueue.peek();
                break;
            } else {
                if (threadQueue.peek() >= tasksStack.peek()) {
                    threadQueue.poll();
                    tasksStack.pop();
                } else {
                    threadQueue.poll();
                }
            }
        }
        System.out.printf("Thread with value %d ", tread);
        System.out.printf("killed task %d%n", taskToKill);
        while (!threadQueue.isEmpty()) {
            System.out.print(threadQueue.poll() + " ");
        }
    }
}


