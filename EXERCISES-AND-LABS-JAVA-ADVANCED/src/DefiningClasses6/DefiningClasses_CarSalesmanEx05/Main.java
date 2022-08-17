package DefiningClasses6.DefiningClasses_CarSalesmanEx05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Engine engine = null;
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            if (tokens.length == 2) {
//            2 параметъра;
                engine = new Engine(model, power);
            } else if (tokens.length == 4) {
//            4 параметъра;
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (tokens.length == 3) {
//            3 параметъра;
                if (Character.isLetter(tokens[2].charAt(0))) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                } else {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                }
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        List<Car1> cars = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car1 car1 = null;
            String model = input[0];
            String engineModel = input[1];
            if (input.length == 2) {
                car1 = new Car1(model, engineModel);
            } else if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car1 = new Car1(model, engineModel, weight, color);
            } else if (input.length == 3) {
                if (Character.isLetter(input[2].charAt(0))) {
                    String color = input[2];
                    car1 = new Car1(model, engineModel, color);
                } else {
                    int weight = Integer.parseInt(input[2]);
                    car1 = new Car1(model, engineModel, weight);
                }
            }
            cars.add(car1);
        }
// лист с коли и лист с двигатели
//FordFocus:
//V4-33:
//Power: 140
//Displacement: 28
//Efficiency: B
//Weight: 1300
//Color: Silver
        for (Car1 car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngineModel() + ":");
            engines.forEach(engine -> {
                if (engine.getModel().equals(car.getEngineModel())) {
                    System.out.println(engine.toString());
                }
            });
            if (car.getWeight() == 0) {
                System.out.println("Weight: n/a");
            } else {
                System.out.println("Weight: " + car.getWeight());
            }
            System.out.println("Color: " + car.getColor());
        }
    }
}
