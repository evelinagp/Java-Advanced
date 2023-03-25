package MultidimensionalArrays2.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifferenceEx03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        fillMatrixType1(scanner, matrix, matrixSize, matrixSize);
        System.out.println(getDiagonalsDifference(matrixSize, matrix));
    }

    private static int getDiagonalsDifference(int matrixSize, int[][] matrix) {
        int sumD1 = 0;
        int sumD2 = 0;

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                int number = matrix[row][col];
                if (row == col) {
//                    числото е на главния диагонал
                    sumD1 += number;
                }

                if (col == matrixSize - 1 - row) {
//                    числото е на второстепенният диагонал
                    sumD2 += number;
                }
            }
        }
        return Math.abs(sumD1 - sumD2);
    }

    private static void fillMatrixType1(Scanner scanner, int[][] matrix, int matrixSize, int matrixSize1) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
    }
}
