package SetsAndMapsAdvanced3.Ex;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregatorEx11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, Long>> info = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            String ip = tokens[0];
            String user = tokens[1];
            long duration = Long.parseLong(tokens[2]);

            if (info.containsKey(user)) {
                Map<String, Long> ipAndDuration = info.get(user);
                if (ipAndDuration.containsKey(ip)) {
                    ipAndDuration.put(ip, ipAndDuration.get(ip) + duration);
                } else {
                    ipAndDuration.put(ip, duration);
                }
            } else {
                info.put(user, new TreeMap<>());
                info.get(user).put(ip, duration);
            }
        }


        info.entrySet().stream()
                .forEach(entry -> {
                    Long totalSum = entry.getValue().values().stream().reduce( 0L, Long::sum);
                    System.out.printf("%s: %d %s%n", entry.getKey(),totalSum
                            ,entry.getValue().keySet());
                });
    }
}

