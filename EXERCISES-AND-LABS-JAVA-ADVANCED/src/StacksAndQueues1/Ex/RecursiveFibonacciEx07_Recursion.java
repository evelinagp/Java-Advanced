package StacksAndQueues1.Ex;

import java.util.Scanner;

public class RecursiveFibonacciEx07_Recursion {
    public static long[] memoryForFib;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        int n = Integer.parseInt(scanner.nextLine());
        memoryForFib = new long[n + 1];
        System.out.println(fib(n));
    }

    public static long fib(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memoryForFib[n] != 0) {
            //имаме го изчислено
            return memoryForFib[n];
        }

        return memoryForFib[n] = fib(n - 1) + fib(n - 2);
    }
}
