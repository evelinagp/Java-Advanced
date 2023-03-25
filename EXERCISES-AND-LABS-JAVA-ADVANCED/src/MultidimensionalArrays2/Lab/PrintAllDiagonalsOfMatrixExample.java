package MultidimensionalArrays2.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintAllDiagonalsOfMatrixExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }
//        Printing diagonals from left top to right bottom
        int row = 0;
        int col = n - 1;
        while (row < n) {
            int innerRow = row;
            int innerCol = col;
            while (innerRow < n && innerCol < n) {
                System.out.print(matrix[innerRow++][innerCol++] + " ");
            }
            System.out.println();
            col--;
            if (col < 0) {
                col = 0;
                row++;
            }

        }
        //        Printing diagonals from rigt top to left bottom uncompleted and NOT correct working
//        int row1 = n - 1;
//        int col1 = 0;
//        while (col1 < n) {
//            int innerRow = row1;
//            int innerCol = col1;
//            while (innerRow >= 0 && innerCol >= 0) {
//                System.out.print(matrix[innerRow--][innerCol--] + " ");
//            }
//            System.out.println();
//            row1--;
//            if (row1 < 0) {
//                row1 = 0;
//                col1++;
//            }
//
//        }
    }

    private static int[][] readMatrix(Scanner scanner, String pattern) {
        int[] rowsAndCols = readArray(scanner, pattern);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner, pattern);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }
}


