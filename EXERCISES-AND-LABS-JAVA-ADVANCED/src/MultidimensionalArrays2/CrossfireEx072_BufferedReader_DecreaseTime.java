package MultidimensionalArrays2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CrossfireEx072_BufferedReader_DecreaseTime {

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
//        Scanner scanner = new Scanner(System.in);
        String[] dimensions = reader.readLine().trim().split("\\s+");
        final int rows = Integer.parseInt(dimensions[0]);
        final int cols = Integer.parseInt(dimensions[1]);

        List<ArrayList<Integer>> matrix = new ArrayList<>();
//        List <Integer> integers = new ArrayList<>();
//        Integer integer = integers.get(0);

        int counter = 1;

        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(counter++);
            }
            matrix.add(numbers);
        }

        String input = reader.readLine().trim();
        while (!input.equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int targetRow = tokens[0];
            int targetCol = tokens[1];
            int radius = tokens[2];

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isValid(row, targetCol, matrix)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }
            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isValid(targetRow, col, matrix)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }
            for (int i = 0; i < matrix.size(); i++) {
//                matrix.get(i).removeAll(new ArrayList<Integer>() {{ add(0); }}) - OK;
                matrix.get(i).removeIf(e -> e == 0);
//                matrix.get(i).remove((Integer) 0);
//                matrix.get(i).removeAll(List.of(0));
                if (matrix.get(i).size() == 0) {
                    matrix.remove(i--);
                }
            }
            input = reader.readLine().trim();
        }
        printMatrix(matrix);
    }

    private static boolean isValid(int row, int col, List<ArrayList<Integer>> matrix) {
        return ((row >= 0 && row < matrix.size()) && (col >= 0 && col < matrix.get(row).size()));
    }


    private static void printMatrix(List<ArrayList<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
