package MultidimensionalArrays2.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatricesLab01_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows1 = size1[0];
        int cols1 = size1[1];
        int[][] matrix1 = readMatrix(rows1, cols1, scanner);

        int[] size2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows2 = size2[0];
        int cols2 = size2[1];
        int[][] matrix2 = readMatrix(rows2, cols2, scanner);

//        areEqual(matrix1, matrix2);
        if (areEqual(matrix1, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean areEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int row = 0; row < matrix1.length; row++) {
            if (matrix1[row].length != matrix2[row].length) {
                return false;
            }
            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
     private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
