//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount savingsAccount = new SavingsAccount("Yash Gokakkar", "S123", 1000, 5);
            savingsAccount.displayAccountDetails();
            savingsAccount.deposit(200);
            savingsAccount.withdraw(500);
            System.out.println("Interest earned: "+savingsAccount.calculateInterest());
            System.out.println("New balance: "+savingsAccount.getBalance());
            System.out.println();

            //Create a current account

        BankAccount currentAccount = new CurrentAccount("Baburao Apte","C456",500,100);
        currentAccount.displayAccountDetails();
        currentAccount.deposit(300);
        currentAccount.withdraw(600); // Within overdraft limit
        currentAccount.withdraw(200); // Exceeds overdraft limit
        System.out.println("Interest earned: "+currentAccount.calculateInterest());
        System.out.println("New balance: "+currentAccount.getBalance());
    }
}