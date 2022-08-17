package StacksAndQueues1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class PriorityQueueExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        priorityQueue.offer(42);
        priorityQueue.offer(13);
        priorityQueue.offer(73);
        priorityQueue.offer(69);

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
