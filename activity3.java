/**
 * 
 */
package ph.com.bpi.hello;

import java.util.Scanner;

public class activity3 {

	public static void main(String[] args) {		

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first integer: ");
        int num1 = input.nextInt();
        
        System.out.print("Enter second integer: ");
        int num2 = input.nextInt();
        
        int sum = num1 + num2;
        int difference = num1 - num2;
        int product = num1 * num2;
        
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);


	}

}
//ACTIVITY 3
//LOUISE SARMIENTO