import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Python {

    public static int sRow = 0, sCol = 0, food = 0, snakeL = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        List<String> commands = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());

        String[][] matrix = fillMatrix(size, reader);

        // printMatrix(matrix);
        boolean eatenByEnemies = false;
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

            switch (command) {
                case "up":
                    eatenByEnemies = moveSnake(matrix, -1, 0);
                    break;
                case "down":
                    eatenByEnemies = moveSnake(matrix, +1, 0);
                    break;
                case "left":
                    eatenByEnemies = moveSnake(matrix, 0, -1);
                    break;
                case "right":
                    eatenByEnemies = moveSnake(matrix, 0, +1);
                    break;
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
        } else if (food <= 0) {
            System.out.printf("You win! Final python length is %d", snakeL);
        } else if (food > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }
    }

    private static boolean moveSnake(String[][] matrix, int row, int col) {
        boolean eaten = false;
        int currentSnakeRow = sRow;
        int currentSnakeCol = sCol;
        matrix[currentSnakeRow][currentSnakeCol] = "*";
        boolean checked = checkHere(matrix, row, col);
        if (matrix[sRow][sCol].equals("*")) {
            matrix[sRow][sCol] = "s";
        } else if (matrix[sRow][sCol].equals("f")) {
            matrix[sRow][sCol] = "s";
            food--;
            snakeL++;
        } else if (matrix[sRow][sCol].equals("e")) {
            eaten = true;

        }
        return eaten;
    }

    private static boolean checkHere(String[][] matrix, int row, int col) {
        boolean checked = false;
        if (row + sRow < 0) {
            sRow = matrix.length - 1;
            checked = true;
        } else if (row + sRow > matrix.length - 1) {
            sRow = 0;
            checked = true;
        }
        if (col + sCol < 0) {
            sCol = matrix.length - 1;
            checked = true;
        } else if (col + sCol > matrix.length - 1) {
            sCol = 0;
            checked = true;
        } else {
            sRow = sRow + row;
            sCol = sCol + col;
        }
        return checked;
    }
    /*private static void printMatrix(String[][] matrix) {

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);

            }
            System.out.println();
        }
    }*/

    private static String[][] fillMatrix(int size, BufferedReader reader) throws IOException {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = reader.readLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = line[col];
                if (line[col].equals("s")) {
                    sRow = row;
                    sCol = col;
                } else if (line[col].equals("f")) {
                    food++;
                }
            }
        }
        return matrix;
    }
}
