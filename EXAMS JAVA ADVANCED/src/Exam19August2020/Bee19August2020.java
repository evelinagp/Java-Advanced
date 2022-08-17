package Exam19August2020;

import java.util.Scanner;

public class Bee19August2020 {

    public static int pollinatedFlowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());


        char[][] matrix = new char[size][size];


        // index 0 is the row of the player
        // index 1 is the column
        int[] position = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = line.charAt(col);
                if ( matrix[row][col] == 'B') {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        boolean isInBounds = true;
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("End")) {
                break;
            }
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
        }
        if (!isInBounds && pollinatedFlowers >= 5) {
            System.out.println("The bee got lost!");
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
        } else if (!isInBounds && pollinatedFlowers < 5) {
            System.out.println(" The bee got lost!");
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - pollinatedFlowers) + " flowers more");
        } else if (isInBounds && pollinatedFlowers >= 5) {
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
        } else if (isInBounds && pollinatedFlowers < 5) {
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - pollinatedFlowers) + " flowers more");
        }
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
            if (matrix[newRow][newCol] == ('.')) {
                matrix[newRow][newCol] = 'B';
                position[0] = newRow;
                position[1] = newCol;
                matrix[row][col] = '.';
            } else if (matrix[newRow][newCol] == ('f')) {
                matrix[row][col] = '.';
                matrix[newRow][newCol] = 'B';
                position[0] = newRow;
                position[1] = newCol;
                pollinatedFlowers++;
            } else if (matrix[newRow][newCol] == ('O')) {
                int nextNewRow = newRow + rowModification;
                int nextNewCol = newCol + colModification;
                if (!isInBounds(nextNewRow, nextNewRow, matrix)) {
                    if (nextNewRow < 0) {
                        nextNewRow = 0;
                    } else if (nextNewRow >= matrix.length) {
                        newRow = matrix.length - 1;
                    }
                    if (nextNewCol < 0) {
                        nextNewCol = 0;
                    } else if (nextNewCol >= matrix.length) {
                        nextNewCol = matrix.length - 1;
                    }
                    hasMoved = false;
                }
                if (matrix[nextNewRow][nextNewCol] == 'f'){
                    pollinatedFlowers++;
                }
                matrix[position[0]][position[1]] = '.';
                matrix[newRow][newCol] = '.';
                matrix[nextNewRow][nextNewCol] = 'B';
                position[0] = nextNewRow;
                position[1] = nextNewCol;
            }
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

