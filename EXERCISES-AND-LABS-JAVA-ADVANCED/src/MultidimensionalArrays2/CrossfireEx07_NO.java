package MultidimensionalArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CrossfireEx07_NO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        List<ArrayList<Integer>> field = new ArrayList<>();


        int counter = 1;

        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(counter++);
            }
            field.add(numbers);
        }

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

//            if (row < 0 || col < 0){
//                input = scanner.nextLine();
//                continue;
//            }
                ArrayList<Integer> currentRow = field.get(row);
            for (int i = Math.max(0, col - radius); i <= Math.min(col + radius, currentRow.size() - 1); i++) {
                currentRow.set(i, -1);
            }
            for (int i = Math.max(0, row - radius); i <= Math.min(col + radius, field.size() - 1); i++) {
                if (col < field.get(i).size()) {
                    field.get(i).set(col, -1);
                }
            }
            for (ArrayList<Integer> integers : field) {
                removeNegativeValues(integers);
            }
            input = scanner.nextLine();
        }
        printMatrix(field);
    }

    private static void removeNegativeValues(ArrayList<Integer> currentRow) {
        while (currentRow.contains(-1)) {
            currentRow.remove(currentRow.indexOf(-1));

        }
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
