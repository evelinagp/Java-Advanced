package StacksAndQueues1.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotatoLab07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (String child : children) {
            queue.offer(child);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (IsPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean IsPrime(int cycle) {
        boolean primeCheck = true;
        if (cycle <= 1) {
            primeCheck = false;
        } else {
            for (int i = 2; i <= Math.sqrt(cycle); i++) {
                if (cycle % i == 0) {
                    primeCheck = false;
                    break;
                }
            }
        }
        return primeCheck;
    }
}

/*
public static boolean isPrime(int n) {
       if (n <= 1) {
           return false;
       }
       for (int i = 2; i < Math.sqrt(n); i++) {
           if (n % i == 0) {
               return false;
           }
       }
       return true;
   }
}
 */
