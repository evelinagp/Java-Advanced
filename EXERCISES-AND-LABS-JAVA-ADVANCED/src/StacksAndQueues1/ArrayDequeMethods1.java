package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ArrayDequeMethods1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        stackOfNumbers.push(13);
        stackOfNumbers.push(42);

        System.out.println(stackOfNumbers.peek());
        System.out.println(stackOfNumbers.pop());
        stackOfNumbers.add(5);
        System.out.println(stackOfNumbers.peek());
        System.out.println(stackOfNumbers.pop());
        System.out.println(stackOfNumbers.size());

    }
}
