package IteratorsAndComparators9.IteratorsAndComparatorsFroggyEx04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] stonesNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        String endWord = scanner.nextLine();
        Lake lake = new Lake(stonesNumbers);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : lake) {
            sb.append(integer).append(", ");
        }
        System.out.println(sb.toString().substring(0, sb.toString().lastIndexOf(", ")));
        }
    }

