package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotatoLab07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int nToss = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String child : children) {
            queue.offer(child);
        }
        int cycle = 1;

        while (queue.size() > 1) {

            for (int i = 1; i < nToss; i++) {

                queue.offer(queue.poll());

                if (cycle != nToss) {
                    queue.offer(queue.poll());
                    System.out.println("Prime " + queue.peek());
                    cycle++;

                } else {
                    System.out.println("Removed " + queue.poll());
                    cycle = 1;
                }
            }
        }
        System.out.println("Last is " + queue.poll());
    }
}

//        int cycle = 1;
//
//        while (queue.size() > 1) {
////
////            for (int i = 1; i < nToss; i++)
////                queue.offer(queue.poll());
//            if (cycle == nToss) {
//                System.out.println("Removed " + queue.poll());
//
//                cycle++;
//
//            } else {
//
//                System.out.println("Prime " + queue.peek());
//            }
//        }
//        System.out.println("Last is " + queue.poll());
//    }
//}