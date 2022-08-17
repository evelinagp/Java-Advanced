package MultidimensionalArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunniesEx10_WithList {
    public static boolean isPlayerDead = false;
    public static int[] rowMovement = {-1, +1, 0, 0};
    public static int[] colMovement = {0, 0, -1, +1};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        char[][] matrix = new char[rows][cols];
        List<Integer> positionsOfB = new ArrayList<>();
        // index 0 is the row of the player
        // index 1 is the column
        int[] positionP = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col].charAt(0);
                if (matrix[row][col] == 'P') {
                    positionP[0] = row;
                    positionP[1] = col;
                    matrix[row][col] = '.';
                }
                if (matrix[row][col] == 'B') {
                    positionsOfB.add(row);
                    positionsOfB.add(col);
                }
            }
        }

        String commandInfo = scanner.nextLine();

        for (int i = 0; i < commandInfo.length(); i++) {
            if (isPlayerDead) {
                break;
            }
            char command = commandInfo.charAt(i);
            moveBunnies(matrix, positionsOfB);
            int playerRow = positionP[0];
            int playerCol = positionP[1];

            switch (command) {
                case 'R':
                    playerCol += 1;
                    break;
                case 'L':
                    playerCol -= 1;
                    break;
                case 'U':
                    playerRow -= 1;
                    break;
                case 'D':
                    playerRow += 1;
                    break;
            }

            if (!isInBounds(playerRow, playerCol, matrix)) {
                break;
            }
            positionP[0] = playerRow;
            positionP[1] = playerCol;

            if (matrix[playerRow][playerCol] == 'B') {
                isPlayerDead = true;
                break;
            }
        }

        printMatrix(matrix);

        if (isPlayerDead) {
            System.out.println("dead: " + positionP[0] + " " + positionP[1]);
        } else {
            System.out.println("won: " + positionP[0] + " " + positionP[1]);
        }

    }

    private static void moveBunnies(char[][] matrix, List<Integer> positionsOfB) {

        int lengthOperations = positionsOfB.size() / 2;
        for (int i = 0; i < lengthOperations; i++) {
            int row = positionsOfB.get(0);
            int col = positionsOfB.get(1);


            for (int j = 0; j < rowMovement.length; j++) {
                int newRow = row + rowMovement[j];
                int newCol = col + colMovement[j];

                if (!isInBounds(newRow, newCol, matrix)) {
                    continue;
                }
                if (matrix[newRow][newCol] == 'B') {
                    continue;
                }
                matrix[newRow][newCol] = 'B';
                positionsOfB.add(newRow);
                positionsOfB.add(newCol);
            }
                positionsOfB.remove(0);
                positionsOfB.remove(0);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
