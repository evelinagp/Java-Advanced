package SetsAndMapsAdvanced3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbolsEx04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map  <Character, Integer> symbolsOccurrences = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (!symbolsOccurrences.containsKey(currentSymbol)){
                symbolsOccurrences.put(currentSymbol, 1);
            }else{
                symbolsOccurrences.put(currentSymbol, symbolsOccurrences.get(currentSymbol) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : symbolsOccurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
