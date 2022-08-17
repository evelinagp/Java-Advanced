package MultidimensionalArrays2;

import java.util.Scanner;

public class ParkingSystemEx09_100Points {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] matrixSize = sc.nextLine().split(" ");
        boolean[][] matrix = new boolean[Integer.parseInt(matrixSize[0])][Integer.parseInt(matrixSize[1])];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }
        while (true) {
            String input = sc.nextLine();
            if (input.equals("stop")) {
                break;
            }
            String[] inputSplit = input.split(" ");
            int entryRow = Integer.parseInt(inputSplit[0]);
            int targetRow = Integer.parseInt(inputSplit[1]);
            int targetCow = Integer.parseInt(inputSplit[2]);
            int distance = Math.abs(entryRow - targetRow) + 1;
            int tempColLeft = 0 >= targetCow - 1 ? 1 : targetCow - 1;
            int tempColRight = targetCow + 1 >= matrix[0].length - 1 ? targetCow : targetCow + 1;
            while (matrix[targetRow][tempColLeft]) {
                if (tempColLeft == 0) {
                    break;
                }
                tempColLeft--;
            }
            while (matrix[targetRow][tempColRight]) {
                if (tempColRight == matrix[0].length - 1) {
                    break;
                }
                tempColRight++;
            }
            if (isRowFull(targetRow, matrix)) {
                System.out.printf("Row %d full\n", targetRow);
                continue;
            }
            if (!matrix[targetRow][targetCow]) {
                matrix[targetRow][targetCow] = true;
                distance += targetCow;
                System.out.println(distance);
                continue;
            } else {
                if ((targetCow - tempColLeft) > (Math.abs(tempColRight - targetCow))) {
                    targetCow = tempColRight;
                } else {
                    targetCow = tempColLeft;
                }
            }
            if (targetCow <= 1 && matrix[targetRow][targetCow]) {
                targetCow = tempColRight;
            }
            if (matrix[targetRow][targetCow] && tempColRight == matrix[0].length - 1) {
                targetCow = tempColLeft;
            }
            matrix[targetRow][targetCow] = true;
            distance += targetCow;
            System.out.println(distance);

        }
    }

    public static boolean isRowFull(int row, boolean[][] matrix) {
        for (int i = 1; i < matrix[0].length; i++) {
            if (!matrix[row][i]) {
                return false;
            }
        }
        return true;
    }
}