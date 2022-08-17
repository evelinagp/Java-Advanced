package Exam28June2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs28June2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().trim().split(", ")).map(Integer::parseInt)
                .forEach(bombEffectsQueue::offer);

        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().trim().split(", ")).map(Integer::parseInt)
                .forEach(bombCasingsStack::push);

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;
        boolean isPouchFilled = false;
//•	Datura Bombs: 40
//•	Cherry Bombs: 60
//•	Smoke Decoy Bombs: 120
        while (!bombEffectsQueue.isEmpty() && !bombCasingsStack.isEmpty()) {
            if (bombEffectsQueue.peek() + bombCasingsStack.peek() == 40) {
                bombEffectsQueue.poll();
                bombCasingsStack.pop();
                daturaBombs++;
            } else if (bombEffectsQueue.peek() + bombCasingsStack.peek() == 60) {
                bombEffectsQueue.poll();
                bombCasingsStack.pop();
                cherryBombs++;
            } else if (bombEffectsQueue.peek() + bombCasingsStack.peek() == 120) {
                bombEffectsQueue.poll();
                bombCasingsStack.pop();
                smokeDecoyBombs++;
            } else {
                int currentNumber = bombCasingsStack.pop();
                bombCasingsStack.push(currentNumber - 5);
            }
            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                isPouchFilled = true;
                break;
            }
        }


        if (isPouchFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.print(bombEffectsQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
        if (bombCasingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.print(bombCasingsStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);

    }
}

