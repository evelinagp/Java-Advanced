package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStackEx01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        List<Integer> inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (Integer number : inputData) {
            numbersStack.push(number);

        }
        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");

//            for (Integer integer : inputData) {
//                System.out.print(numbersStack.pop() + " ");
            }
        }
    }
