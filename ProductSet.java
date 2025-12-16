package M3_Activity2;

import java.util.HashSet;
import java.util.Scanner;

public class ProductSet {

    public static void main(String[] args) {
        HashSet<String> products = new HashSet<>();
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Printer");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (1–4): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter product name to search: ");
                    String searchItem = scanner.nextLine();
                    if (products.contains(searchItem)) {
                        System.out.println("Product found: " + searchItem);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter product name to add: ");
                    String newProduct = scanner.nextLine();
                    if (products.add(newProduct)) {
                        System.out.println("Product added: " + newProduct);
                    } else {
                        System.out.println("Product already exists.");
                    }
                    break;

                case 3:
                    System.out.println("\nAll products:");
                    int index = 1;
                    for (String product : products) {
                        System.out.println(index++ + ". " + product);
                    }
                    System.out.println("Total unique products: " + products.size());
                    break;

                case 4:
                    System.out.println("Program Ended!");
                    break;

                default:
                    System.out.println("Invalid selection. Please select 1–4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}