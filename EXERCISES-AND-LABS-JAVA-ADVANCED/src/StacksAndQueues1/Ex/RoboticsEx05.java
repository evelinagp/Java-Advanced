package StacksAndQueues1.Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RoboticsEx05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> robots = Arrays.stream(scanner.nextLine().split(";"))
                .collect(Collectors.toList());
        String[] names = new String[robots.size()];
        int[] processTime = new int[robots.size()];

        for (int i = 0; i < robots.size(); i++) {
            String[] tokens = robots.get(i).split("-");
            String name = tokens[0];
            names[i] = name;
            int time = Integer.parseInt(tokens[1]);
            processTime[i] = time;
        }
        String startTime = scanner.nextLine();
        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String inputProduct;

        while (!(inputProduct = scanner.nextLine()).equals("End")) {
            productsQueue.offer(inputProduct);
        }
        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

//        convert time in seconds
        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        int[] robotWorkLeft = new int[robots.size()];

        while (!productsQueue.isEmpty()) {
//            robots should take a product if they are available
            startTimeInSeconds++;
            String product = productsQueue.poll();
            int index = -1; //assume that the robot in NOT Available

            for (int i = 0; i < robotWorkLeft.length; i++) {
                if (robotWorkLeft[i] > 0) {
//                    robot is working
                    robotWorkLeft[i]--;
                }
                if (robotWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }
            if (index != -1) {
//                assign the product to a robot
                robotWorkLeft[index] = processTime[index];
                String robot = names[index];
                System.out.println(printRobotData(robot, product, startTimeInSeconds));
            } else {
//                index = -1 -> all robots are busy
                productsQueue.offer(product);
            }
        }
    }

    private static String printRobotData(String robot, String product, int startTimeInSeconds) {
        long hours = startTimeInSeconds / 3600 % 24;
        long minutes = (startTimeInSeconds / 60) % 60;
        long seconds = startTimeInSeconds % 60;
        return String.format("%s - %s [%02d:%02d:%02d]", robot, product, hours, minutes, seconds);

    }
}

