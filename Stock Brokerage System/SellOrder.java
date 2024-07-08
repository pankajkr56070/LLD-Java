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
    public void execute() {
        // Check if the user has sufficient quantity of the stock to sell
        // Update portfolio and perform necessary actions
        double totalProceeds = quantity * price;
        account.deposit(totalProceeds);
        status = OrderStatus.EXECUTED;
    }
}