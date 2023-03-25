package StacksAndQueues1.Lab;

import java.util.ArrayDeque;

public class ArrayDequeMethods {
    public static void main(String[] args) {

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();
        ArrayDeque<Integer> queueOfNumbers = new ArrayDeque<>();

        stackOfNumbers.push(13);
        stackOfNumbers.push(42);

        queueOfNumbers.offer(69);
        queueOfNumbers.offer(73);

        System.out.println(stackOfNumbers.peek());
        System.out.println(queueOfNumbers.peek());
        System.out.println(stackOfNumbers.pop());
        System.out.println(queueOfNumbers.poll());
        stackOfNumbers.add(5);
        queueOfNumbers.add(5);
        System.out.println(stackOfNumbers.peek());
        System.out.println(stackOfNumbers.pop());
        System.out.println(stackOfNumbers.size());
        System.out.println(queueOfNumbers.peek());
        System.out.println(queueOfNumbers.poll());
        System.out.println(queueOfNumbers.size());

    }
}
