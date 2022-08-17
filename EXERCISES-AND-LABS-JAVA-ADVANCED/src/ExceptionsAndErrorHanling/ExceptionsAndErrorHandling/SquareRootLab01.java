package ExceptionsAndErrorHanling.ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRootLab01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            double sqrt = sqrt(scanner);
            System.out.println(sqrt);
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Good bye");
        }
    }

    public static double sqrt(Scanner scanner) {
        String str = scanner.nextLine();
        for (char symbol : str.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                throw new NumberFormatException("Invalid number!");
            }
        }
        return Math.sqrt(Integer.parseInt(str)) ;
    }
}
