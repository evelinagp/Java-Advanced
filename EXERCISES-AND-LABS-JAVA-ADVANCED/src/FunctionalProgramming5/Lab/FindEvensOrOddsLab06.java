package FunctionalProgramming5.Lab;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindEvensOrOddsLab06 {
    public static void main(String[] args) {


        // obtain list size
        Scanner scanner = new Scanner(System.in);

        List<Integer> initialList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        String option = scanner.nextLine();

        long min = Collections.min(initialList);
        long max = Collections.max(initialList);

        List<Long> list = new ArrayList<>();

        // list populate
        for (long i = min; i <= max; i++) {
            list.add(i);
        }

        // declare predicate
        Predicate<Long> even = x -> x % 2 == 0;

        Predicate<Long> odd = x -> x % 2 != 0;

        //output processing
        List<Long> result;
        if (option.equals("odd")) {
            result = list.stream().filter(odd).collect(Collectors.toList());
        } else {
            result = list.stream().filter(even).collect(Collectors.toList());
        }

        // result print
        result.forEach(e-> System.out.print(e + " "));
    }
}
