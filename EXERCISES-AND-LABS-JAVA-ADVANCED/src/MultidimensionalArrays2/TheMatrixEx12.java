package MultidimensionalArrays2;

import java.util.*;

public class TheMatrixEx12 {
    private static int[] currentPosition = new int[2];
    private static final int[] rowMovement = {1, -1, 0, 0};
    private static final int[] colMovement = {0, 0, 1, -1};
    private static boolean isPlayerDead = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> positionsOfStartChar = new ArrayList<>();
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }

        char fillChar = scanner.nextLine().charAt(0);
        int[] coordinatesOfPosition = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startRow = coordinatesOfPosition[0];
        int startCol = coordinatesOfPosition[1];
        char startChar = matrix[startRow][startCol];
//        List<Integer> currentPosition = new ArrayList<>();
        for (int row = startRow; row < matrix.length; row++) {
            for (int col = startCol; col < matrix[row].length; col++) {
                if (spreadingTheChar(positionsOfStartChar, matrix, startChar, row, col)) break;
            }
        }
        for (int row = startRow; row >= 0; row--) {
            for (int col = startCol; col < matrix[row].length; col++) {
                if (spreadingTheChar(positionsOfStartChar, matrix, startChar, row, col)) break;
            }
        }

        for (int i = 0; i < positionsOfStartChar.size(); i += 2) {
            int pos1 = positionsOfStartChar.get(i);
            int pos2 = positionsOfStartChar.get(i + 1);

            matrix[pos1][pos2] = fillChar;
        }

        matrix[startRow][startCol] = fillChar;

        printCharMatrix(matrix);

    }

    private static boolean spreadingTheChar(List<Integer> positionsOfStartChar, char[][] matrix, char startChar, int row, int col) {
        if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] == startChar && matrix[row][col] == startChar) {
            positionsOfStartChar.add(row - 1);
            positionsOfStartChar.add(col);
        }
        if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] == startChar && matrix[row][col] == startChar) {
            positionsOfStartChar.add(row + 1);
            positionsOfStartChar.add(col);
        }
        if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] == startChar && matrix[row][col] == startChar) {
            positionsOfStartChar.add(row);
            positionsOfStartChar.add(col - 1);
        }
        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] == startChar && matrix[row][col] == startChar) {
            positionsOfStartChar.add(row);
            positionsOfStartChar.add(col + 1);
        }
        if (!isInBounds(row, col, matrix)) {
            return true;
        }
        return false;
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printCharMatrix(char[][] finalMatrix) {
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

}


