package MultidimensionalArrays2;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShufflingEx05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = tokens[0];
        int m = tokens[1];

        String[][] matrix = new String[n][m];


        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
//            first
            String command = data[0];
            if (data.length == 5 && command.equals("swap")) {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
//            second
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                swapElements(row1, col1, row2, col2, matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static void swapElements(int row1, int col1, int row2, int col2, String[][] matrix) {
        if (isValid(row1, col1, matrix) && isValid(row2, col2, matrix)) {
            String tempElement = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = tempElement;
            printMatrix(matrix);
        } else {
            System.out.println("Invalid input!");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] ints : matrix) {
            for (String number : ints) {
                System.out.printf("%s ", number);
            }
            System.out.println();
        }
    }

    private static boolean isValid(int row1, int col1, String[][] matrix) {
        if (row1 >= 0 && row1 < matrix.length && col1 >= 0 && col1 < matrix[row1].length) {
            return true;
        }
        return false;
    }
}

