package StacksAndQueues1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BalancedParenthesesEx06_75Points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "[{+]\\[+(?<middle>\\(+\\)+)+\\]+[}+]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean isMatchingFound = false;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        if (input.length() % 2 == 0 && (input.length() >= 1 && input.length() <= 1000)) {
            while (matcher.find()) {
                for (int i = 0; i < input.length(); i++) {
                    char currentSymbol = input.charAt(i);
                    switch (currentSymbol) {
                        case '{':
                            count1++;
                            break;
                        case '[':
                            count2++;
                            break;
                        case '(':
                            count3++;
                            break;
                        case ')':
                            count4++;
                            break;
                        case ']':
                            count5++;
                            break;
                        case '}':
                            count6++;
                            break;
                    }
                }
                if (count1 == count6 && count2 == count5 && count3 == count4) {
                    isMatchingFound = true;
                }
            }
        }
        if (isMatchingFound) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
