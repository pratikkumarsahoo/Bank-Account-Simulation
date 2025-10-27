import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class to represent a bank account
class Account {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: ₹" + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
            System.out.println("✅ Successfully deposited ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount + " | New Balance: ₹" + balance);
            System.out.println("✅ Successfully withdrawn ₹" + amount);
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    // Display transaction history
    public void showTransactionHistory() {
        System.out.println("\n📜 Transaction History for " + accountHolderName + ":");
        for (String record : transactionHistory) {
            System.out.println(" - " + record);
        }
    }
}

// Main class
public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🏦 Welcome to the Bank Account Simulation!");
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        String accNumber = sc.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double initialBalance = sc.nextDouble();

        Account account = new Account(name, accNumber, initialBalance);

        int choice;
        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = sc.nextDouble();
                    account.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = sc.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    account.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("👋 Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
