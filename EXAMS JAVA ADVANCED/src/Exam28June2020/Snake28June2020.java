package Exam28June2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake28June2020 {

    public static int eatenFood = 0;
    public static List<Integer> positionsB;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        positionsB = new ArrayList<>();
        int size = Integer.parseInt(scanner.nextLine());


        char[][] matrix = new char[size][size];


        // index 0 is the row of the player
        // index 1 is the column
        int[] position = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'S') {
                    position[0] = row;
                    position[1] = col;
                } else if (matrix[row][col] == 'B') {
                    positionsB.add(row);
                    positionsB.add(col);
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
            if (eatenFood >= 10) {
                break;
            }
        }
        if (!isInBounds) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + eatenFood);
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
            matrix[newRow][newCol] = '.';
        } else {
            if (matrix[newRow][newCol] == ('-')) {
                matrix[newRow][newCol] = 'S';
                matrix[row][col] = '.';
            } else if (matrix[newRow][newCol] == ('*')) {
                matrix[row][col] = '.';
                matrix[newRow][newCol] = 'S';
                eatenFood++;
            } else if (matrix[newRow][newCol] == ('B')) {
                if (newRow == positionsB.get(0) && newCol == positionsB.get(1)) {
                    newRow = positionsB.get(2);
                    newCol = positionsB.get(3);
                    matrix[positionsB.get(0)][positionsB.get(1)] = '.';
                    matrix[positionsB.get(2)][positionsB.get(3)] = 'S';
                } else if (newRow == positionsB.get(2) && newCol == positionsB.get(3)) {
                    newRow = positionsB.get(0);
                    newCol = positionsB.get(1);
                    matrix[positionsB.get(2)][positionsB.get(3)] = '.';
                    matrix[positionsB.get(0)][positionsB.get(1)] = 'S';
                }
                matrix[row][col] = '.';
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


