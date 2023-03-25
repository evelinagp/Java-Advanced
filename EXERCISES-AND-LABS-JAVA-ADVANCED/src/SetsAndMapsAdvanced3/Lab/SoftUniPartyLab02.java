package SetsAndMapsAdvanced3.Lab;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniPartyLab02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        TreeSet<String> vips = new TreeSet<>();
        TreeSet<String> regulars = new TreeSet<>();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vips.add(input);
            } else if (Character.isLetter(input.charAt(0))) {
                regulars.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {
            vips.remove(input);
            regulars.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(vips.size() + regulars.size());
        for (String vip : vips) {
            System.out.println(vip);
        }
        for (String regular : regulars) {
            System.out.println(regular);
        }
    }
}

