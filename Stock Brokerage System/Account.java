
public interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    String getAccountId();
    User getUser();
    Portfolio getPortfolio();
    double getBalance();

}
