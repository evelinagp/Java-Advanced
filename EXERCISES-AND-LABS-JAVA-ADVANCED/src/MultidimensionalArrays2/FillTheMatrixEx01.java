package MultidimensionalArrays2;

import java.util.Scanner;

public class FillTheMatrixEx01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(", ");

        int n = Integer.parseInt(tokens[0]);
        String fillPattern = tokens[1];

        int[][] matrix = fillMatrix(n, fillPattern);
        printMatrix(matrix);
    }

    private static int[][] fillMatrix(int n, String fillPattern) {
        int[][] matrix = new int[n][n];
        if (fillPattern.equals("A")) {
            fillPatternA(matrix);
        } else if (fillPattern.equals("B")) {
            fillPatternB(matrix);
        }
        return matrix;
    }

    private static void fillPatternB(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[col][row] = number++;
                }
            } else {
                for (int col = matrix[row].length - 1; col >= 0; col--) {
                    matrix[col][row] = number++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = number++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }
}

