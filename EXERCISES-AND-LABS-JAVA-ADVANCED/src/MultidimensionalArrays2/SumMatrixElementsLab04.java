package MultidimensionalArrays2;

import java.util.Arrays;
import java.util.Scanner;


public class SumMatrixElementsLab04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

//        ВАРИАНТ СЪС СТРИЙМ АПИ
//        int sum = Arrays.stream(matrix).flatMapToInt(IntStream::of).sum();
// СТАНДАРТЕН ВАРИАНТ
        int sum = 0;
        for (int[] arr : matrix) {
            for (int number : arr) {
                sum += number;
            }
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
    }
}

