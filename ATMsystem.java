package M4_Activity2;

public class ATMsystem {

 
	    static double[] accounts = {10000, 15000, 20000};
 
	    public static void processWithdrawal(String accountIndex, String amountInput) {
	        System.out.println("Account=" + accountIndex + ", Amount=" + amountInput);
	        try {
	            int index = Integer.parseInt(accountIndex);
	            double balance = accounts[index];
	            double amount = Double.parseDouble(amountInput);
 
	            System.out.printf("Current balance: ₱%.2f%n", balance);
	            System.out.printf("Withdrawal: ₱%.2f%n", amount);
 
	            if (amount > balance) {
	                System.out.printf("Insufficient funds! Cannot withdraw ₱%.2f%n", amount);
	            } else {
	                accounts[index] -= amount;
	                System.out.printf("New balance: ₱%.2f%n", accounts[index]);
	                System.out.println("Withdrawal successful!");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Error: Invalid input!");
	            System.out.println("Please enter valid numbers.");
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("Error: Account not found!");
	            System.out.println("Invalid account index.");
	        } catch (Exception e) {
	            System.out.println("Error: Transaction failed!");
	            System.out.println("Unexpected error occurred.");
	        }
	    }
 
	    public static void main(String[] args) {
	        System.out.println("=== ATM Withdrawal System ===\n");
 
	        System.out.println("--- Test 1: Valid Withdrawal ---");
	        processWithdrawal("1", "5000");
	        System.out.println();
 
	        System.out.println("--- Test 2: Invalid Account Index ---");
	        processWithdrawal("abc", "5000");
	        System.out.println();
 
	        System.out.println("--- Test 3: Account Not Found ---");
	        processWithdrawal("10", "5000");
	        System.out.println();
 
	        System.out.println("--- Test 4: Insufficient Funds ---");
	        processWithdrawal("1", "20000");
	        System.out.println();
 
	        System.out.println("=== All tests completed! ===");
	    }
	}