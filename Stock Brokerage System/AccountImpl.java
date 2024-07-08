// Concrete implementation of Account interface
public class AccountImpl implements Account {
    private final String accountId;
    private final User user;
    private final Portfolio portfolio;
    private final BalanceManager balanceManager;

    public AccountImpl(String accountId, User user, double initialBalance, Portfolio portfolio) {
        this.accountId = accountId;
        this.user = user;
        this.balanceManager = new BalanceManager(initialBalance);
        this.portfolio = portfolio;
    }

    public String getAccountId() {
        return accountId;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balanceManager.getBalance();
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    // Violating Single Responsibility Principle (SRP) : Each class should have only
    // one reason to change.
    // This class handles both balance management and portfolio management.
    // Hence , separating this class into Balance Management and Portfolio
    // Management in the Account Class
    public void deposit(double amount) {
        balanceManager.deposit(amount);
    }

    public void withdraw(double amount) {
        balanceManager.withdraw(amount);
    }

}