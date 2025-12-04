/**
 * 
 */
package ph.com.bpi.hello;

import java.util.Scanner;

public class activity4 {

	public static void main(String[] args) {		

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        
        if (age >= 18 && age < 60) {
        	System.out.println("Adult");
        } else if (age < 18) {
        	System.out.println("Minor");
        } else {
        	System.out.println("Senior");
        }

	}

}
//ACTIVITY 4
//LOUISE SARMIENTO