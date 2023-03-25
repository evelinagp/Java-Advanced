package SetsAndMapsAdvanced3.Ex;

import java.util.*;

public class UserLogsEx09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> info = new TreeMap<>();

        while (!input.equals("end")) {
//        IP = {ip}, message = {message}, user = {username}
            String[] tokens = input.split("\\s+");

            String username = tokens[2].split("=")[1];
            String message = tokens[1].split("=")[1];
            String ip = tokens[0].split("=")[1];

//            info.putIfAbsent(username, new LinkedHashMap<>());
//            info.get(username).putIfAbsent(ip, 0); //добавя запис, ако го няма
//            info.get(username).put(ip, info.get(username).get(ip) + 1);
            if (info.containsKey(username)) {
                LinkedHashMap<String, Integer> ips = info.get(username);
                if (ips.containsKey(ip)) {
                    ips.put(ip, ips.get(ip) + 1);
                } else {
                    ips.put(ip, 1);
                }
            } else {
                info.put(username, new LinkedHashMap<>());
                info.get(username).put(ip, 1);
            }
            input = scanner.nextLine();
        }
        info.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            int countEntry = entry.getValue().size();
            for (var ipEntry : entry.getValue().entrySet()) {
                if (countEntry > 1) {
                    System.out.println(ipEntry.getKey() + " => " + ipEntry.getValue() + ", ");
                } else {
                    System.out.println(ipEntry.getKey() + " => " + ipEntry.getValue() + ". ");
                }
                countEntry--;
            }
            System.out.println();
        });
    }
}
