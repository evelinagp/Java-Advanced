import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int commands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int[] position = new int[2];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().trim();
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'P') {
                    position[0] = row;
                    position[1] = col;

                }
            }
        }

        boolean isProgramEnd = false;
        for (int i = 0; i < commands; i++) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                isProgramEnd = movePlayer(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                isProgramEnd = movePlayer(position, matrix, +1, 0);
            } else if (command.equals("left")) {
                isProgramEnd = movePlayer(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                isProgramEnd = movePlayer(position, matrix, 0, +1);
            }

            if (isProgramEnd) {
                break;
            }
        }
        if (isProgramEnd) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static boolean movePlayer(int[] position, char[][] matrix,
                                      int rowModification, int colModification) {
        int row = position[0];
        int col = position[1];
        int newRow = getBackCorrectIndex(row + rowModification, matrix.length);
        int newCol = getBackCorrectIndex(col + colModification, matrix.length);

        boolean end = false;

        if (matrix[newRow][newCol] == ('.')) {
            matrix[newRow][newCol] = 'P';
            matrix[row][col] = '.';
            position[0] = newRow;
            position[1] = newCol;
        } else if (matrix[newRow][newCol] == ('B')) {
            int nextNewRow = getBackCorrectIndex(newRow + rowModification, matrix.length);
            int nextNewCol = getBackCorrectIndex(newCol + colModification, matrix.length);
            if (matrix[nextNewRow][nextNewCol] == 'F') {
                end = true;
            }
            matrix[nextNewRow][nextNewCol] = 'P';
            position[0] = nextNewRow;
            position[1] = nextNewCol;
            matrix[row][col] = '.';

        } else if (matrix[newRow][newCol] == 'T') {
            matrix[newRow][newCol] = 'T';
            int priviosRow = getBackCorrectIndex(newRow - rowModification, matrix.length);
            int priviosCol = getBackCorrectIndex(newCol - colModification, matrix.length);
            matrix[priviosRow][priviosCol] = 'P';
            position[0] = priviosRow;
            position[1] = priviosCol;
        } else if (matrix[newRow][newCol] == 'F') {
            matrix[newRow][newCol] = 'P';
            matrix[row][col] = '.';
            position[0] = newRow;
            position[1] = newCol;
            end = true;
        }
        return end;
    }


    private static int getBackCorrectIndex(int index/*row/col + row/colModification*/, int bounds/*matrix.length*/) {
        if (index < 0) {
            index = bounds - 1;
        } else if (index >= bounds) {
            index = 0;
        }

        return index;
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
