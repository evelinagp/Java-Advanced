package IteratorsAndComparators9.IteratorsAndComparatorsStrategyPatternEx06;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet <Person> comparedByName = new TreeSet<>(new PersonNameComparator());
        TreeSet <Person> comparedByAge = new TreeSet<>(new PersonAgeComparator());
        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            comparedByName.add(person);
            comparedByAge.add(person);
        }
        comparedByName.forEach(System.out::println);
        comparedByAge.forEach(System.out::println);
    }
}