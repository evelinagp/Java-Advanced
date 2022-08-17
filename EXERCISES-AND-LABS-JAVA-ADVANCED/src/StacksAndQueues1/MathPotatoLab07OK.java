package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotatoLab07OK {
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
        if (cycle == 0 || cycle == 1) {
            primeCheck = false;
        } else {
            for (int i = 2; i <= Math.sqrt(cycle); i++) {
                if (cycle % i == 0) {
                    primeCheck = false;
                }
            }
        }
        return primeCheck;
    }
}


