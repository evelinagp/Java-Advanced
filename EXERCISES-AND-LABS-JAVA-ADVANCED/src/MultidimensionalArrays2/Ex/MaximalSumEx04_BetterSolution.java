package MultidimensionalArrays2.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSumEx04_BetterSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner, "\\s+");
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        System.out.println(matrix[maxRow][maxCol] + " " + matrix[maxRow][maxCol + 1] + " " + matrix[maxRow][maxCol + 2]);
        System.out.println(matrix[maxRow + 1][maxCol] + " " + matrix[maxRow + 1][maxCol + 1] + " " + matrix[maxRow + 1][maxCol + 2]);
        System.out.println(matrix[maxRow + 2][maxCol] + " " + matrix[maxRow + 2][maxCol + 1] + " " + matrix[maxRow + 2][maxCol + 2]);
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
