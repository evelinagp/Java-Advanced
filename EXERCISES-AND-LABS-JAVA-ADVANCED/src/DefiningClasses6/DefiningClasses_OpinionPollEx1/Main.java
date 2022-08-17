package DefiningClasses6.DefiningClasses_OpinionPollEx1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if (age > 30) {
                Person person = new Person(name, age);
                people.add(person);
            }
        }
//списък с хората > 30
        people.sort(Comparator.comparing(p -> p.getName()));
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
