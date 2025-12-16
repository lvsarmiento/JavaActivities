package M3_Activity3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapOperations {

    public static void main(String[] args) {
        Map<String, Double> products = new HashMap<>();
        products.put("Laptop", 50000.0);
        products.put("Mouse", 500.0);
        products.put("Keyboard", 2100.0);
        products.put("Monitor", 10500.0);
        products.put("Printer", 5800.0);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and prices");
            System.out.println("4. Find the cheapest product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (1–5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    if (products.containsKey(searchName)) {
                        System.out.println("Product found: " + searchName + " - ₱" + products.get(searchName));
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter product name to add: ");
                    String newName = scanner.nextLine();
                    if (products.containsKey(newName)) {
                        System.out.println("Product already exists.");
                    } else {
                        System.out.print("Enter price for " + newName + ": ");
                        while (!scanner.hasNextDouble()) {
                            System.out.print("Invalid price. Enter a valid number: ");
                            scanner.next();
                        }
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        products.put(newName, newPrice);
                        System.out.println("Product added: " + newName + " - ₱" + newPrice);
                    }
                    break;

                case 3:
                    System.out.println("\nAll products and prices:");
                    int index = 1;
                    for (Map.Entry<String, Double> entry : products.entrySet()) {
                        System.out.printf("%d. %s - ₱%.2f%n", index++, entry.getKey(), entry.getValue());
                    }
                    System.out.println("Total products: " + products.size());
                    break;

                case 4:
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        String cheapestProduct = null;
                        double minPrice = Double.MAX_VALUE;
                        for (Map.Entry<String, Double> entry : products.entrySet()) {
                            if (entry.getValue() < minPrice) {
                                minPrice = entry.getValue();
                                cheapestProduct = entry.getKey();
                            }
                        }
                        System.out.println("Cheapest product: " + cheapestProduct + " - ₱" + minPrice);
                    }
                    break;

                case 5:
                    System.out.println("Program Ended!");
                    break;

                default:
                    System.out.println("Invalid selection. Please select 1–5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}