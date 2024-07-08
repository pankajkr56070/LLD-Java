
// Concrete Strategy: Limit Order
public class LimitOrderStrategy implements OrderExecutionStrategy {
    private final Account account;
    private final Stock stock;
    private final int quantity;
    private final double price;

    public LimitOrderStrategy(Account account, Stock stock, int quantity, double price) {
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public void execute() {
        // Implement limit order execution logic
        // Example: Check if current stock price matches or exceeds the limit price
        double currentPrice = stock.getPrice();
        if (currentPrice <= price) {
            double totalCost = quantity * currentPrice;
            if (account.getBalance() >= totalCost) {
                account.withdraw(totalCost);
                account.getPortfolio().addStock(stock, quantity);
                System.out.println("Limit Order executed successfully.");
            } else {
                throw new InsufficientFundsException("Insufficient funds to execute the limit order.");
            }
        } else {
            throw new IllegalArgumentException("Current price is higher than the limit price.");
        }
    }
}