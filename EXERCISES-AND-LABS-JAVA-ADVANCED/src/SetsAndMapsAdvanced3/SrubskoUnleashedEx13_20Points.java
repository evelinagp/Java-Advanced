package SetsAndMapsAdvanced3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashedEx13_20Points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(?<name>([A-Za-z]*\\s){1,3})@(?<city>([A-Za-z]*\\s){1,3})(?<price>[0-9]*)\\s(?<count>[0-9]*)";

        Pattern pattern = Pattern.compile(regex);

        Map<String, LinkedHashMap<String, Long>> concert = new LinkedHashMap<>();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name").trim();
                String city = matcher.group("city").trim();
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));

                long totalPrice = price * count;


                if (concert.containsKey(city)) {
                    Map<String, Long> namesAndTotalPrice = concert.get(city);
                    if (namesAndTotalPrice.containsKey(name)) {
                        namesAndTotalPrice.put(name, namesAndTotalPrice.get(name) + totalPrice);
                    } else {
                        namesAndTotalPrice.put(name, totalPrice);
                    }
                } else {
                    concert.put(city, new LinkedHashMap<>());
                    concert.get(city).put(name, totalPrice);
                }
            }
            input = scanner.nextLine();
        }

        for (String city : concert.keySet()) {
            System.out.println(city);

            LinkedHashMap<String, Long> singers = concert.get(city);
            singers.entrySet().stream().sorted((singer1, singer2) -> singer2.getValue().compareTo(singer1.getValue()))
                    .forEach(singer -> System.out.println(String.format("#  %s -> %d", singer.getKey(), singer.getValue())));
        }
    }
}
