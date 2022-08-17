package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotatoLab06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int nToss = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }
        int i = 1;
        while (queue.size() > 1) {
            if (i == nToss) {
                System.out.println("Removed" + " " + queue.poll());
                i = 1;
            } else {
                queue.offer(queue.poll());
                i += 1;
            }
        }
        System.out.println("Last is" + " " + queue.poll());
    }
}


