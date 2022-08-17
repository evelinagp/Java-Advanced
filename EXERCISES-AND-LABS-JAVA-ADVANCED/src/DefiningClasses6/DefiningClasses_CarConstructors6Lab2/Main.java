package DefiningClasses6.DefiningClasses_CarConstructors6Lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<DefiningClasses_CarConstructors6_2.Car> cars = new ArrayList<>();
        DefiningClasses_CarConstructors6_2.Car car;
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 1) {
                car = new DefiningClasses_CarConstructors6_2.Car(tokens[0]);
            } else {
                car = new DefiningClasses_CarConstructors6_2.Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            cars.add(car);
        }
        System.out.println(cars.stream().map(DefiningClasses_CarConstructors6_2.Car::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}


