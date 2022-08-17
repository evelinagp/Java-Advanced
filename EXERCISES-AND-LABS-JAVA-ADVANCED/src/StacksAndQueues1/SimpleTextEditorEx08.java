package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditorEx08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> memoryStack = new ArrayDeque<>();

        for (int i = 0; i < numberOfOperations; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            if (tokens.length == 1 && command.equals("4")) {
                if (!memoryStack.isEmpty()) {
                    text = new StringBuilder(memoryStack.pop());
                }
            } else if (tokens.length == 2) {
                String argument = tokens[1];
                switch (command) {
                    case "1":
                        memoryStack.push(text.toString());
                        text.append(argument);
                        break;
                    case "2":
                        int count = Integer.parseInt(argument);
                        memoryStack.push(text.toString());
                        text = new StringBuilder(text.substring(0, text.length() - count));

                        break;
                    case "3":
                        int index = Integer.parseInt(argument);
                        System.out.println(text.charAt(index - 1));
                        break;
                }
            }
       }
    }
}

