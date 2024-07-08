
public class BalanceManager {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public BalanceManager(double initialBalance) {
        validateInitialBalance(initialBalance);
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Account balance is now " + balance);
    }
    
    //Atomic operation
    public synchronized void withdraw(double amount) {
        validateAmount(amount);
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Account balance is now " + balance);
        } else {
            throw new InsufficientFundsException("Insufficient funds in the account.");
        }
    }

    private void validateInitialBalance(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative.");
        }
    }

    private void validateAmount(double amount) {        
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
    }

}
