package Generics8.Ex.GenericCustomListSorterEx08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
//•	Add <element> - Adds the given element to the end of the list
//•	Remove <index> - Removes the element at the given index
//•	Contains <element> - Prints if the list contains the given element (true or false)
//•	Swap <index> <index> - Swaps the elements at the given indexes
//•	Greater <element> - Counts the elements that are greater than the given element and prints their count
//•	Max - Prints thSwape maximum element in the list
//•	Min - Prints theMax minimum element in the list
//•	Print - Prints all elements in the list, each on a separate line
//•	END - stops the reading of commands
            switch (command) {
                case "Add":
                    String element = tokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    customList.remove(indexToRemove);
                    break;
                case "Contains":
                    String searchedElement = tokens[1];
                    System.out.println(customList.contains(searchedElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elementForCompare = tokens[1];
                    System.out.println(customList.countGreaterThan(elementForCompare));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String s : customList) {
                    System.out.println(s);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
//                default:
//                    System.out.println("Invalid command.");
            }
            input = scanner.nextLine();
        }
    }
}
