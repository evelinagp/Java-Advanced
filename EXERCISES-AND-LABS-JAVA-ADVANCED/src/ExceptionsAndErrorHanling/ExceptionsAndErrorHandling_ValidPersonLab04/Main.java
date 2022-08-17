package ExceptionsAndErrorHanling.ExceptionsAndErrorHandling_ValidPersonLab04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Person p = createPerson("Pesho", "Petrov", 19);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Person createPerson(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, age);
    }
}
