public class SellOrder extends Order {
    /**
     * @param orderId
     * @param account
     * @param stock
     * @param quantity
     * @param price
     */
    public SellOrder(String orderId, Account account, Stock stock, int quantity, double price) {
        super(orderId, account, stock, quantity, price);
    }

    @Override
    // ensuring atomicity within methods like withdraw is only part of the solution.
    // You must also ensure that the entire process of checking the balance and
    // updating it, as well as updating the portfolio, is atomic when placing
    // orders.
    public void execute() {
        // Check if the user has sufficient quantity of the stock to sell
        synchronized (account) {
            Portfolio portfolio = account.getPortfolio();
            if (portfolio.getHoldings().getOrDefault(stock.getSymbol(), 0) >= quantity) {
                portfolio.removeStock(stock, quantity);
                // Update portfolio and perform necessary actions
                double totalProceeds = quantity * price;
                account.deposit(totalProceeds);
                status = OrderStatus.EXECUTED;
            } else {
                status = OrderStatus.REJECTED;
                throw new InsufficientStockException("Insufficient stock quantity to execute the sell order.");
            }
        }

    }
}