package MultidimensionalArrays2.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatricesLab01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;

        if (!areNotEqual) {
            for (int rows = 0; rows < firstMatrix.length; rows++) {
                int[] firstArr = firstMatrix[rows];
                int[] secondArr = secondMatrix[rows];
                areNotEqual = firstArr.length != secondArr.length;
                if (!areNotEqual) {
                    for (int col = 0; col < firstArr.length; col++) {
                        if (firstArr[col] != secondArr[col]){
                            areNotEqual = true;
                            break;
                        }
                    }
                }
                if (areNotEqual){
                    break;
                }
            }
        }

        String output = areNotEqual ? "not equal" : "equal";
        System.out.println(output);
//       printMatrix(firstMatrix);
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

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
//            int[] arr = matrix[row];
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
