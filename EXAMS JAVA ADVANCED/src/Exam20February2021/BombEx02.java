package Exam20February2021;

import java.util.Scanner;

public class BombEx02 {
    public static int bombs = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

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
                } else if (matrix[row][col] == 'B') {
                    bombs++;
                }
            }
        }

        boolean endOfTheRoute = false;
        for (int i = 0, commandsLength = commands.length; i < commandsLength; i++) {
            String command = commands[i];
            if (command.equals("up")) {
                endOfTheRoute = movePlayer(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                endOfTheRoute = movePlayer(position, matrix, +1, 0);
            } else if (command.equals("left")) {
                endOfTheRoute = movePlayer(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                endOfTheRoute = movePlayer(position, matrix, 0, +1);
            }

            if (endOfTheRoute) {
                break;
            }

            if (bombs <= 0) {
                break;
            }
        }
        if (endOfTheRoute) {
            System.out.printf("END! %d bombs left on the field", bombs);
        } else {
            if (bombs <= 0) {
                System.out.println("Congratulations! You found all bombs!");
            } else {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, position[0], position[1]);
            }
        }
    }

    private static boolean movePlayer(int[] position, char[][] matrix,
                                      int rowModification, int colModification) {
        int row = position[0];
        int col = position[1];
        int newRow = getBackCorrectIndex(row + rowModification, matrix.length);
        int newCol = getBackCorrectIndex(col + colModification, matrix.length);

        boolean hasReachedTheEnd = false;


        if (matrix[newRow][newCol] == ('+')) {
            matrix[newRow][newCol] = 's';
        } else if (matrix[newRow][newCol] == ('B')) {
            matrix[newRow][newCol] = 's';
            bombs--;
            System.out.println("You found a bomb!");
        } else if (matrix[newRow][newCol] == 'e') {
            hasReachedTheEnd = true;
        }
        matrix[row][col] = '+';
        position[0] = newRow;
        position[1] = newCol;
        return hasReachedTheEnd;
    }


    private static int getBackCorrectIndex(int index/*row/col + row/colModification*/, int bounds/*matrix.length*/) {
        if (index < 0) {
            index = 0;
        } else if (index >= bounds) {
            index = bounds - 1;
        }

        return index;
    }
}

