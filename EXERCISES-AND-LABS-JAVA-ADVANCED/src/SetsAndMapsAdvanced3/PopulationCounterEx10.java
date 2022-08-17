package SetsAndMapsAdvanced3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PopulationCounterEx10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Long>> info = new LinkedHashMap<>();

        while (!input.equals("report")) {
//        IP = {ip}, message = {message}, user = {username}
            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

//            info.putIfAbsent(username, new LinkedHashMap<>());
//            info.get(username).putIfAbsent(ip, 0); //добавя запис, ако го няма
//            info.get(username).put(ip, info.get(username).get(ip) + 1);
            if (info.containsKey(country)) {
                Map<String, Long> citiesAndPopulation = info.get(country);
                if (citiesAndPopulation.containsKey(city)) {
                    citiesAndPopulation.put(city, citiesAndPopulation.get(city) + population);
                } else {
                    citiesAndPopulation.put(city, population);
                }
            } else {
                info.put(country, new TreeMap<>());
                info.get(country).put(city, population);
            }
            input = scanner.nextLine();
        }
        info.entrySet().stream()
                .sorted((country1, country2) -> country2.getValue().values().stream().reduce(0L, Long::sum)
                        .compareTo(country1.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(),
                            country.getValue().values().stream().reduce(0L, Long::sum));
                    country.getValue().entrySet().stream()
                            .sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
