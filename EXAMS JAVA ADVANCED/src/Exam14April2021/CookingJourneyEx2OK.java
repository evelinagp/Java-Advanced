package Exam14April2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookingJourneyEx2OK {
    public static int totalPrice = 0;
    public static List<Integer> positionsP;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        positionsP = new ArrayList<>();
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];


        // index 0 is the row of the player
        // index 1 is the column
        int[] position = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = line.charAt(col);
                if (line.charAt(col) == 'S') {
                    position[0] = row;
                    position[1] = col;
                } else if (line.charAt(col) == 'P') {
                    positionsP.add(row);
                    positionsP.add(col);
                }
            }
        }
        boolean isInBounds = true;
        while (true) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                isInBounds = movePlayer(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                isInBounds = movePlayer(position, matrix, +1, 0);
            } else if (command.equals("left")) {
                isInBounds = movePlayer(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                isInBounds = movePlayer(position, matrix, 0, +1);
            }
            if (!isInBounds) {
                break;
            }
            if (totalPrice >= 50) {
                break;
            }
        }
        if (!isInBounds) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            if (totalPrice >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
            } else {
                System.out.println("Bad news! You are out of the pastry shop.");
            }
        }
        System.out.println("Money: " + totalPrice);
        printMatrix(matrix);
    }

    private static boolean movePlayer(int[] position, char[][] matrix,
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
            matrix[newRow][newCol] = '-';
        } else {
            if (matrix[newRow][newCol] == ('-')) {
                matrix[newRow][newCol] = 'S';
            } else if (Character.isDigit(matrix[newRow][newCol])) {
                int number = Integer.parseInt(String.valueOf(matrix[newRow][newCol]));
                totalPrice += number;
                matrix[newRow][newCol] = 'S';

            } else if (matrix[newRow][newCol] == ('P')) {
                if (newRow == positionsP.get(0) && newCol == positionsP.get(1)) {
                    newRow = positionsP.get(2);
                    newCol = positionsP.get(3);
                    matrix[positionsP.get(0)][positionsP.get(1)] = '-';
                    matrix[newRow][newCol] = 'S';
                } else if (newRow == positionsP.get(2) && newCol == positionsP.get(3)) {
                    newRow = positionsP.get(0);
                    newCol = positionsP.get(1);
                    matrix[positionsP.get(2)][positionsP.get(3)] = '-';
                    matrix[newRow][newCol] = 'S';
                }
            }
            position[0] = newRow;
            position[1] = newCol;
            matrix[row][col] = '-';
        }

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
