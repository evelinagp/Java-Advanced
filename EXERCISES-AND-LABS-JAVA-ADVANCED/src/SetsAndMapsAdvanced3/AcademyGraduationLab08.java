package SetsAndMapsAdvanced3;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduationLab08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> nameAndGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] scoreSettings = scanner.nextLine().split("\\s+");
            for (int j = 0; j < scoreSettings.length; j++) {
                Double currentGrade = Double.parseDouble(scoreSettings[j]);
                nameAndGrades.putIfAbsent(name, new ArrayList<>());
                nameAndGrades.get(name).add(currentGrade);
            }
        }
        nameAndGrades.entrySet().stream().forEach(entry -> {
            DecimalFormat df = new DecimalFormat("#.###############");
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.printf("%s is graduated with %s%n", entry.getKey(), df.format(average));
        });
    }
}
