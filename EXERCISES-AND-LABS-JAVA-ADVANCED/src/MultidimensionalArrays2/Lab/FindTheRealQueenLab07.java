package MultidimensionalArrays2.Lab;

import java.util.Scanner;

public class FindTheRealQueenLab07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = 8;
        int cols = 8;

        char[][] chessTable = readMatrix(rows, cols, scan);

        for (int row = 0; row < chessTable.length; row++) {
            for (int col = 0; col < chessTable[row].length; col++) {
                char currentElement = chessTable[row][col];

                if (currentElement == 'q') {
                    if (check(chessTable, row, col)) {
                        System.out.print(row + " " + col);
                    }

                }
            }
        }
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = line[col].charAt(0);
                matrix[row][col] = currentChar;
            }

        }
        return matrix;
    }

    private static boolean check(char[][] chessTable, int row, int col) {

        for (int i = col + 1; i < chessTable[row].length; i++) { //RightHorizontal yes
            char charToCheck = chessTable[row][i];

            if (charToCheck == 'q') {
                return false;
            }
        }

        for (int i = col - 1; i >= 0; i--) { //LeftHorizontal yes
            char charToCheck = chessTable[row][i];

            if (charToCheck == 'q') {
                return false;
            }
        }


        for (int i = row + 1; i < chessTable.length; i++) { //DownVertical yes
            char charToCheck = chessTable[i][col];

            if (charToCheck == 'q') {
                return false;
            }
        }

        for (int i = row - 1; i >= 0; i--) { // UpVertical yes
            char charToCheck = chessTable[i][col];

            if (charToCheck == 'q') {
                return false;
            }
        }

        int colLeftMoving = col - 1;

        for (int i = row - 1; i >= 0 && colLeftMoving >= 0; i--, colLeftMoving--) { // UpLeftDiagonal yes
            char charToCheck = chessTable[i][colLeftMoving];

            if (charToCheck == 'q') {
                return false;

            }
        }

        int colRightMoving = col + 1;

        for (int i = row - 1; i >= 0 && colRightMoving < chessTable[i].length; i--, colRightMoving++) { // UpRightDiagonal yes
            char charToCheck = chessTable[i][colRightMoving];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int element = col - 1;

        for (int i = row + 1; i < chessTable.length && element >= 0; i++, element--) { // DownLeftDiagonal
            char charToCheck = chessTable[i][element];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int element1 = col + 1;

        for (int i = row + 1; i < chessTable.length && element1 < chessTable[row].length; i++, element1++) { // DownRightDiagonal
            char charToCheck = chessTable[i][element1];

            if (charToCheck == 'q') {
                return false;
            }
        }
        return true;
    }
}
