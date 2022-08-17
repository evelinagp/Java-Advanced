package SetsAndMapsAdvanced3;

import java.util.*;

public class ProductShopLab06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map <String, Map<String, Double>> shopAndProducts = new TreeMap<>();

        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopAndProducts.putIfAbsent(shop, new LinkedHashMap<>());
            shopAndProducts.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        shopAndProducts.entrySet().stream().forEach(entry ->{
            System.out.println(entry.getKey() + "->");
            entry.getValue().entrySet().stream().forEach(innerEntry ->{
                System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());
            });
        });
    }
}
