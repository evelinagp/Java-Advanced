package StacksAndQueues1.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgradeLab08NO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String currentURL = null;

        ArrayDeque<String> history = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentURL = history.pop();
                }
            } else if (command.equals("forward")) {
                if (history.isEmpty()) {
                    System.out.println("no next URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentURL = history.pop();
                }
            } else {
                if (currentURL != null) {
                    history.push(currentURL);
                }
                currentURL = command;
            }

            System.out.println(currentURL);
            command = scanner.nextLine();
        }
    }
}

//•	Use clear() method to reset the forward pages
//•	Use addFirst() when adding page to the forward pages

