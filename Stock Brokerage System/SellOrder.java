public class SellOrder extends Order {

    /**
     * @param orderId
     * @param account
     * @param stock
     * @param quantity
     * @param price
     * @param validator
     */
    public SellOrder(String orderId, Account account, Stock stock, int quantity, double price, OrderValidator validator, OrderExecutionStrategy strategy) {
        super(orderId, account, stock, quantity, price, validator, strategy);
    }

    @Override
    // ensuring atomicity within methods like withdraw is only part of the solution.
    // You must also ensure that the entire process of checking the balance and
    // updating it, as well as updating the portfolio, is atomic when placing
    // orders.
    public void execute() {
        // Check if the user has sufficient quantity of the stock to sell
        strategy.execute();

    }
}


