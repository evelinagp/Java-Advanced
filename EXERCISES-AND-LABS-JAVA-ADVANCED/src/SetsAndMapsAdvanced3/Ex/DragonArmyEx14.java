package SetsAndMapsAdvanced3.Ex;

import java.util.*;

public class DragonArmyEx14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, List<Double>>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            if (tokens[2].equals("null")) {
                tokens[2] = "45";
            }
            double damage = Double.parseDouble(tokens[2]);


            if (tokens[3].equals("null")) {
                tokens[3] = "250";
            }
            double health = Double.parseDouble(tokens[3]);

            if (tokens[4].equals("null")) {
                tokens[4] = "10";
            }
            double armor = Double.parseDouble(tokens[4]);

            dragons.putIfAbsent(type, new TreeMap<>());

            Map<String, List<Double>> nameAndStats = dragons.get(type);
            if (nameAndStats.containsKey(name)) {
                List<Double> stats = nameAndStats.get(name);
                stats.clear();
                stats.add(damage);
                stats.add(health);
                stats.add(armor);
                dragons.get(type).put(name, stats);


            } else {
                nameAndStats.put(name, new ArrayList<>());
                List<Double> stats = nameAndStats.get(name);
                stats.add(damage);
                stats.add(health);
                stats.add(armor);

            }
        }
        dragons.entrySet().forEach(e -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", (Object) e.getKey(), e.getValue().values().stream().mapToDouble(value -> value.get(0)).average().getAsDouble(),
                    e.getValue().values().stream().mapToDouble(value -> value.get(1)).average().getAsDouble(),
                    e.getValue().values().stream().mapToDouble(value -> value.get(2)).average().getAsDouble());
            e.getValue().entrySet().stream().forEach(innerEntry -> {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", innerEntry.getKey(), innerEntry.getValue().get(0)
                        , innerEntry.getValue().get(1), innerEntry.getValue().get(2));

            });
        });
    }
}






