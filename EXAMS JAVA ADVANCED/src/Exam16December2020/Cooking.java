package Exam16December2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().trim().split("\\s+")).map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().trim().split("\\s+")).map(Integer::parseInt)
                .forEach(ingredientsStack::push);


        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;
        boolean isPouchFilled = false;
//Bread	25
//Cake	50
//Pastry	75
//Fruit Pie	100
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            if (liquidsQueue.peek() + ingredientsStack.peek() == 25) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                bread++;
            } else if (liquidsQueue.peek() + ingredientsStack.peek() == 50) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                cake++;
            } else if (liquidsQueue.peek() + ingredientsStack.peek() == 75) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                pastry++;
            } else if (liquidsQueue.peek() + ingredientsStack.peek() == 100) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                fruitPie++;
            } else {
                liquidsQueue.poll();
                int currentNumber = ingredientsStack.pop();
                ingredientsStack.push(currentNumber + 3);
            }
        }
        if (bread >= 1 && cake >= 1 && pastry >= 1 && fruitPie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.print(liquidsQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.print(ingredientsStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Bread: %d", bread)).append(System.lineSeparator());
        sb.append(String.format("Cake: %d", cake)).append(System.lineSeparator());
        sb.append(String.format("Fruit Pie: %d", fruitPie)).append(System.lineSeparator());
        sb.append(String.format("Pastry: %d", pastry)).append(System.lineSeparator());
        System.out.println(sb.toString().trim());
    }
}
