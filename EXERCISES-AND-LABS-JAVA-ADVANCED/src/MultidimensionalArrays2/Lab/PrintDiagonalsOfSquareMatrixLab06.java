package MultidimensionalArrays2.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrixLab06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }
        int row = 0;
        int col = 0;
//        Първи диагонал - отляво отгоре надясно надолу
        while (row < n && col < n) {
            System.out.print(matrix[row++][col++] + " ");
        }
//        Втори диагонал - отляво отдолу надясно нагоре
        row = n - 1;
        col = 0;
        System.out.println();
        while (row >= 0 && col < n) {
            System.out.print(matrix[row--][col++] + " ");
        }
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }
}
