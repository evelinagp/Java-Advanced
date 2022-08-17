package FunctionalProgramming5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModuleEx11_BufferedReader {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> guests = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> predicates = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String predicateName = tokens[1] + tokens[2];
            if (tokens[0].contains("Add")) {
                Predicate<String> predicate = getPredicate(tokens);
                predicates.put(predicateName, predicate);
            } else if (tokens[0].contains("Remove")) {
//                remove
                predicates.remove(predicateName);
            }
        }
        guests.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(guest)) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(e -> System.out.println(e + " "));

    }

    private static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;
        switch (tokens[1]) {
            case "Starts with":
                predicate = name -> name.startsWith(tokens[2]);
                break;
            case "Ends with":
                predicate = name -> name.endsWith((tokens[2]));
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(tokens[2]);
                break;
            default:
//            contains
                predicate = name -> name.contains(tokens[2]);
                break;
        }
        return predicate;
    }
}


