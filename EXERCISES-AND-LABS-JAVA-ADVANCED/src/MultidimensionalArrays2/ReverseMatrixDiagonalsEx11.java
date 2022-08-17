package MultidimensionalArrays2;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonalsEx11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        fillMatrixType1(scanner, matrix);
        for (int col = matrix.length; col >= 0; col--) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                int number = matrix[row][col];
                if (col == rows - 1 - row) {
//                    числото е на второстепенният диагонал
                }
                System.out.println(number);
                System.out.println();

//          row == i
//        col == n+1+row;
            }
        }
    }

    private static void fillMatrixType1(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
    }
}
