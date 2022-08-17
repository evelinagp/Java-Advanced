package MultidimensionalArrays2;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystemEx09_80Points {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = data[0];
        int m = data[1];

        if (n >= 2 && n <= 10000 && m >= 2 && m <= 10000) {

            boolean[][] isOccupied = new boolean[n][m];
            for (int i = 0; i < isOccupied.length; i++) {
                isOccupied[i][0] = true;
            }
            String input = scanner.nextLine();
            while (!input.equals("stop")) {
                String[] tokens = input.split("\\s+");
                int entryRow = Integer.parseInt(tokens[0]);
                int targetRow = Integer.parseInt(tokens[1]);
                int targetCol = Integer.parseInt(tokens[2]);
//                if (rowsAndColsAreInBounds(entryRow, targetCol, targetRow, isOccupied)) {
                    if (targetCol != 0) {
                        boolean hasFoundFreePlace = false;
                        int traveledDistance = 1;
                        traveledDistance += Math.abs(targetRow - entryRow);

                        if (!isOccupied[targetRow][targetCol]) {
                            traveledDistance += targetCol;
                            isOccupied[targetRow][targetCol] = true;
                            hasFoundFreePlace = true;
                        } else {
                            for (int i = 1; i < isOccupied[targetRow].length; i++) {
                                if (targetCol - i > 0 && !isOccupied[targetRow][targetCol - i]) {
                                    isOccupied[targetRow][targetCol - i] = true;
                                    hasFoundFreePlace = true;
                                    traveledDistance += targetCol - i;
                                    break;
                                }
                                if (targetCol + i < isOccupied[targetRow].length && !isOccupied[targetRow][targetCol + i]) {
                                    isOccupied[targetRow][targetCol + i] = true;
                                    hasFoundFreePlace = true;
                                    traveledDistance += targetCol + i;
                                    break;
                                }
                            }
                        }


                        if (hasFoundFreePlace) {
                            System.out.println(traveledDistance);
                        } else {
                            System.out.printf("Row %d full", targetRow);
                        }
                    }
                input = scanner.nextLine();
                }
//                }else{
//                    break;
//                }
            }
        }
//    }

//    private static boolean rowsAndColsAreInBounds(int entryRow, int targetCol, int targetRow, boolean[][] isOccupied) {
//        return (entryRow >= 0 && entryRow <= isOccupied.length && targetCol > 0 && targetCol <= isOccupied.length
//                && targetRow >= 0 && targetRow <= isOccupied.length);
//    }
    }


