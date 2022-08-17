package StacksAndQueues1;

import java.util.Scanner;

public class RecursiveFibonacciEx07_OK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] fibonacci = new long[n + 1];
        long lastNumber = 0;
        if (n >= 1 && n <= 49) {
            for (int i = 0; i < fibonacci.length; i++) {
                if (i <= 1) {
                    fibonacci[i] = 1;
                    lastNumber = fibonacci[i];
                } else {
                    fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
                    lastNumber = fibonacci[i];
                }
            }
            System.out.println(lastNumber);
        }
    }
}
