package StacksAndQueues1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesesEx06OK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol == '(' || currentSymbol == '[' || currentSymbol == '{') {
                openBracketsStack.push(currentSymbol);
            } else if (currentSymbol == ')' || currentSymbol == ']' || currentSymbol == '}') {
                if (openBracketsStack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = openBracketsStack.pop();
                if (lastOpenBracket == '(' && currentSymbol == ')') {
                    areBalanced = true;
                } else if (lastOpenBracket == '[' && currentSymbol == ']') {
                    areBalanced = true;
                } else if (lastOpenBracket == '{' && currentSymbol == '}') {
                    areBalanced = true;
                }else {
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
