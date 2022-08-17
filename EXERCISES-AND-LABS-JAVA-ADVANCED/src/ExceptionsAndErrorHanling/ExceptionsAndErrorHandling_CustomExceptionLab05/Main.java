package ExceptionsAndErrorHanling.ExceptionsAndErrorHandling_CustomExceptionLab05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Student student = new Student("4avdar", "teat@test.com");
        } catch (InvalidPersonNameException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
