package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class QueueMethods {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbers = input.split("\\s+");

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (String integer : numbers) {
            queue.offer(Integer.parseInt(integer));
        }

        int element = queue.peek();

        int size = queue.size();

        boolean exists = queue.contains(element);

//        Integer [] arr = queue.toArray();


    }
}
