
// Concrete Strategy: Stop Order
public class StopOrderStrategy implements OrderExecutionStrategy {
    private final Account account;
    private final Stock stock;
    private final int quantity;
    private final double price;

    public StopOrderStrategy(Account account, Stock stock, int quantity, double price) {
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public void execute() {
        // Implement stop order execution logic
        // Example: Check if current stock price falls below the stop price
        double currentPrice = stock.getPrice();
        if (currentPrice >= price) {
            double totalProceeds = quantity * currentPrice;
            account.deposit(totalProceeds);
            account.getPortfolio().removeStock(stock, quantity);
            System.out.println("Stop Order executed successfully.");
        } else {
            throw new IllegalArgumentException("Current price is lower than the stop price.");
        }
    }
}