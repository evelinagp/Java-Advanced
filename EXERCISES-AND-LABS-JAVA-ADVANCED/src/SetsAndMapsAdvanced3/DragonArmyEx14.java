package SetsAndMapsAdvanced3;

import java.lang.reflect.Array;
import java.util.*;

public class DragonArmyEx14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = Integer.parseInt(tokens[2]);
            int health = Integer.parseInt(tokens[3]);
            int armor = Integer.parseInt(tokens[4]);


            Map<String, List<Integer>> nameAndStats = dragons.get(type);
            if (dragons.containsKey(type)) {
                if (nameAndStats.containsKey(name)) {
                    List<Integer> stats = nameAndStats.get(name);
//                    if (stats.isEmpty()){
                    stats.add(damage);
                    stats.add(health);
                    stats.add(armor);
                    nameAndStats.put(name, stats);

                } else {
                    nameAndStats.put(name, new ArrayList<>());
                    List<Integer> stats = nameAndStats.get(name);
//                    if (stats.isEmpty()){
                    stats.add(damage);
                    stats.add(health);
                    stats.add(armor);
                    nameAndStats.put(name, stats);
                }
            } else {
                dragons.put(type, new TreeMap<>());

//                Map<String, List<Integer>> nameAndStats = dragons.get(type);
                dragons.get(type).put(name, new ArrayList<>());
                List<Integer> stats = nameAndStats.get(name);
//                    if (stats.isEmpty()){
                stats.add(damage);
                stats.add(health);
                stats.add(armor);
                nameAndStats.put(name, stats);
            }
        }
    }
}


