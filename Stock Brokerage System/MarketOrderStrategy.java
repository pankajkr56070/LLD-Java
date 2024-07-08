
// Concrete Strategy: Market Order
public class MarketOrderStrategy implements OrderExecutionStrategy {
    private final Account account;
    private final Stock stock;
    private final int quantity;
    private final double price;

    public MarketOrderStrategy(Account account, Stock stock, int quantity, double price) {
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public void execute() {
        // Implement market order execution logic
        double totalCost = quantity * price;
        if (account.getBalance() >= totalCost) {
            account.withdraw(totalCost);
            account.getPortfolio().addStock(stock, quantity);
            System.out.println("Market Order executed successfully.");
        } else {
            throw new InsufficientFundsException("Insufficient funds to execute the market order.");
        }
    }
}