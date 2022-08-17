package MultidimensionalArrays2;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrixLab062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, size);
//        Главен диагонал
        int row = 0;
        int col = 0;
        while (row < size && col < size) {
            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();
//        Второстепенен диагонал
        row = size - 1;
        col = 0;
        while (row >= 0 && col < size) {
            System.out.print(matrix[row--][col++] + " ");
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {

        int rows = size;
        int cols = size;

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}

