package DefiningClasses6.Ex.DefiningClasses_GoogleEx07;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Person> personData = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String enteredData = tokens[1];
            if (!personData.containsKey(name)) {
                personData.put(name, new Person());
            }
            switch (enteredData) {
                case "company":
                    //•	"<Name> company <companyName> <department> <salary>" -> 5 параметъра;
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    personData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    //•	"<Name> pokemon <pokemonName> <pokemonType>" -> 4 параметъра;
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon2 pokemon2 = new Pokemon2(pokemonName, pokemonType);
                    personData.get(name).getPokemons().add(pokemon2);
                    break;
                case "parents":
                    //•	"<Name> parents <parentName> <parentBirthday>" -> 4 параметъра;
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    personData.get(name).getParents().add(parent);
                    break;
                case "children":
                    //•	"<Name> children <childName> <childBirthday>" -> 4 параметъра;
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName, childBirthday);
                    personData.get(name).getChildren().add(child);
                    break;
                case "car":
                    //•	"<Name> car <carModel> <carSpeed>" -> 4 параметъра;
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    GoogleCar googleCar = new GoogleCar(carModel, carSpeed);
                    personData.get(name).setCar(googleCar);
                    break;
            }
            input = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalData = personData.get(searchedPerson);
        System.out.println(personalData.toString());
    }
}
