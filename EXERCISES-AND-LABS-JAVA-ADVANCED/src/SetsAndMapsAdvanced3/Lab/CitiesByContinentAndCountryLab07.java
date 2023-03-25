package SetsAndMapsAdvanced3.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CitiesByContinentAndCountryLab07 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, Map<String, List<String>>> continentsData = new LinkedHashMap();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String continents = tokens[0];
            String countries = tokens[1];
            String cities = tokens[2];
            continentsData.putIfAbsent(continents, new LinkedHashMap<>());
            continentsData.get(continents).putIfAbsent(countries, new ArrayList<>());
            continentsData.get(continents).get(countries).add(cities);
        }
        continentsData.entrySet().stream().forEach(entry ->{
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().stream().forEach(innerEntry ->{
                System.out.println("\t" + innerEntry.getKey() + " -> " + String.join(", ", innerEntry.getValue()));
            });
        });
    }
}
