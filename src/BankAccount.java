// Abstract class representing a generic Bank Account
abstract class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Abstract method for calculating interest
    abstract double calculateInterest();

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Method to get account balance
    public double getBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Concrete class representing a Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountHolderName, String accountNumber, double initialBalance, double interestRate) {
        super(accountHolderName, accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

// Concrete class representing a Current Account
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountHolderName, String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountHolderName, accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    double calculateInterest() {
        return 0; // No interest for current accounts
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + overdraftLimit)) {
            // Allow withdrawal within overdraft limit
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or exceeds overdraft limit!");
        }
    }
}
