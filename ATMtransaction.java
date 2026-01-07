package M4_Activity3;

public class ATMtransaction {
 
    public static void checkBalance(String accountNumber, double balance) {
        try {
            System.out.println("Processing balance inquiry...");
            
            // Validate account number format
            Integer.parseInt(accountNumber);
 
            // Get account type from first character
            char accountType = accountNumber.charAt(0);
            switch (accountType) {
                case '1':
                    System.out.println("Account Type: Savings");
                    break;
                case '2':
                    System.out.println("Account Type: Checking");
                    break;
                default:
                    System.out.println("Account Type: Unknown");
            }
 
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Current Balance: ₱" + balance);
            System.out.println("Balance inquiry successful!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid account number format! Account numbers must be numeric.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Account number is empty or invalid!");
        } finally {
            System.out.println("\n=========== RECEIPT ============");
            System.out.println("Transaction Date: December 3, 2025");
            System.out.println("Transaction Type: Balance Inquiry");
            System.out.println("ATM Location: Main Branch");
            System.out.println("Thank you for banking with us!");
            System.out.println("================================\n");
        }
    }
 
    public static void main(String[] args) {
        checkBalance("100123456", 15000.00);     // Valid Savings
        checkBalance("200987654", 25000.00);     // Valid Checking
        checkBalance("ABC12345", 15000.00);      // Invalid format
        checkBalance("", 15000.00);              // Empty string
    }
}