package Exam26June2021;

import java.util.Scanner;

public class Python2_26June2021 {
    public static int food = 0, snakeLength = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[size][size];


        // index 0 is the row of the player
        // index 1 is the column
        int[] position = new int[2];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().trim().replaceAll(" ", "");
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 's') {
                    position[0] = row;
                    position[1] = col;
                } else if (matrix[row][col] == 'f') {
                    food++;
                }
            }
        }

        boolean eatenByEnemies = false;
        for (int i = 0, commandsLength = commands.length; i < commandsLength; i++) {
            String command = commands[i];
            if (command.equals("up")) {
                eatenByEnemies = movePlayer(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                eatenByEnemies = movePlayer(position, matrix, +1, 0);
            } else if (command.equals("left")) {
                eatenByEnemies = movePlayer(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                eatenByEnemies = movePlayer(position, matrix, 0, +1);
            }

            if (eatenByEnemies) {
                break;
            }

            if (food <= 0) {
                break;
            }
        }
        if (eatenByEnemies) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            if (food <= 0) {
                System.out.printf("You win! Final python length is %d", snakeLength);
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.", food);
            }
        }
    }

    private static boolean movePlayer(int[] position, char[][] matrix,
                                      int rowModification, int colModification) {
        int row = position[0];
        int col = position[1];
        int newRow = getBackCorrectIndex(row + rowModification, matrix.length);
        int newCol = getBackCorrectIndex(col + colModification, matrix.length);

        boolean eaten = false;


        if (matrix[newRow][newCol] == ('*')) {
            matrix[newRow][newCol] = 's';
        } else if (matrix[newRow][newCol] == ('f')) {
            matrix[newRow][newCol] = 's';
            food--;
            snakeLength++;
        } else if (matrix[newRow][newCol] == 'e') {
            eaten = true;
        }
        matrix[row][col] = '*';
        position[0] = newRow;
        position[1] = newCol;
        return eaten;
    }


    private static int getBackCorrectIndex(int index/*row/col + row/colModification*/, int bounds/*matrix.length*/) {
        if (index < 0) {
            index = bounds - 1;
        } else if (index >= bounds) {
            index = 0;
        }

        return index;
    }
}

