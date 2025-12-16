package M3_Activity1;


import java.util.ArrayList;
import java.util.Scanner;

public class ProductList {

		// Method
		public static void printList(ArrayList<String> list) {
		    for (int i = 0; i < list.size(); i++) {
		        System.out.println((i + 1) + ". " + list.get(i));
		    }
		}
		
	    public static void main(String[] args) {
	        // product list
	        ArrayList<String> products = new ArrayList<>();
	        products.add("Laptop");
	        products.add("Mouse");
	        products.add("Keyboard");
	        products.add("Monitor");
	        products.add("Printer");

	        // Print all products
	        System.out.println("All products:");
	        printList(products);

	        // Add Webcam, remove Mouse
	        products.add("Webcam");
	        products.remove("Mouse");

	        System.out.println("\nAfter adding and removing products:");
	        printList(products);

	        // Search product name
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("\nEnter product name to search: ");
	        String searchItem = scanner.nextLine();

	        if (products.contains(searchItem)) {
	            System.out.println("Product found: " + searchItem);
	        } else {
	            System.out.println("Product not found.");
	        }

	        scanner.close();
	    }

	}


