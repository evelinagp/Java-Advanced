package SetsAndMapsAdvanced3;

import java.text.DecimalFormat;
import java.util.*;

public class AverageStudentsGradesLab05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> nameAndGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            Double currentGrade = Double.parseDouble(tokens[1]);
            nameAndGrades.putIfAbsent(name, new ArrayList<>());
            nameAndGrades.get(name).add(currentGrade);
        }
//        for (Map.Entry<String, List<Double>> entry : nameAndGrades.entrySet()) {
     nameAndGrades.entrySet().stream()
                .forEach(entry -> {
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), entry.getValue() ,average);
        });
    }
}

//  country.getValue().entrySet().stream()
//                            .sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
//                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));