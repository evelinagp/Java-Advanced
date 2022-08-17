package Exam26Oct2019;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookWorm {

    public static int newRow = 0, newCol = 0;
    public static String string;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine();

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];


        // index 0 is the row of the player
        // index 1 is the column
        int[] position = new int[2];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.trim().toCharArray();

            if (line.contains("P")) {
                position[0] = row;
                position[1] = line.indexOf("P");
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.equals("up")) {
                isPlayerMoved(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                isPlayerMoved(position, matrix, +1, 0);
            } else if (command.equals("left")) {
                isPlayerMoved(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                isPlayerMoved(position, matrix, 0, +1);
            }
            command = scanner.nextLine();
        }
        System.out.println(string);
        printMatrix(matrix);

    }

    private static boolean isPlayerMoved(int[] position, char[][] matrix,
                                         int rowModification, int colModification) {
        int row = position[0];
        int col = position[1];
        int newRow = row + rowModification;
        int newCol = col + colModification;

        boolean hasMoved = true;

        if (!isInBounds(newRow, newCol, matrix)) {
            if (newRow < 0) {
                newRow = 0;
            } else if (newRow >= matrix.length) {
                newRow = matrix.length - 1;
            }
            if (newCol < 0) {
                newCol = 0;
            } else if (newCol >= matrix.length) {
                newCol = matrix.length - 1;
            }
            hasMoved = false;
            string = string.substring(0, string.length() - 1);
            matrix[row][col] = 'P';

        } else {
            if (matrix[newRow][newCol] == ('-')) {
                matrix[newRow][newCol] = 'P';
                matrix[row][col] = '-';
            } else if (Character.isLetter(matrix[newRow][newCol])) {
                string += matrix[newRow][newCol];
                matrix[row][col] = '-';
                matrix[newRow][newCol] = 'P';
            }
        }
        position[0] = newRow;
        position[1] = newCol;


        return hasMoved;
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {

        for (char[] strings : matrix) {
            for (char string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}

