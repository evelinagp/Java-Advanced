package DefiningClasses6.Lab.DefiningClasses_BankAccount6Lab3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Integer, BankAccount> accountsMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accountsMap.put(bankAccount.getId(), bankAccount);
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                double amount = Double.parseDouble(tokens[2]);
                accountsMap.get(id).deposit(amount);
            } else if (command.equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                accountsMap.get(id).getInterest(years);

            }
            input = scanner.nextLine();
        }
    }
}
