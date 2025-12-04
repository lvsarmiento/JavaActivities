/**
 * 
 */
package ph.com.bpi.hello;

import java.util.Scanner;

public class activity2 {

	public static void main(String[] args) {		

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        
        String age = input.nextLine();
        
        int ageInt = Integer.parseInt(age);
        
        double ageDouble = Double.parseDouble(age);
        
        System.out.println("Your age as int: " + ageInt);
        System.out.println("Your age as double: " + ageDouble);

	}

}
//ACTIVITY 2
//LOUISE SARMIENTO