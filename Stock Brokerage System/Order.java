public abstract class Order {
    protected final String orderId;
    protected final Account account;
    protected final Stock stock;

    protected final int quantity;
    protected final double price;
    protected OrderStatus status;

    protected OrderValidator validator;
    // Order Processing: If you add new order types (e.g., limit orders, stop
    // orders), you might need to modify existing code. Using a strategy pattern can
    // help.
    private OrderExecutionStrategy executionStrategy;

    // Open/Closed Principle (OCP) : Classes should be open for extension but closed
    // for modification.
    // Order Processing: If you add new order types (e.g., limit orders, stop
    // orders), you might need to modify existing code. Using a strategy pattern can
    // help.
    public Order(String orderId, Account account, Stock stock, int quantity, double price, OrderValidator validator,
            OrderExecutionStrategy executionStrategy) {
        this.orderId = orderId;
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.status = OrderStatus.PENDING;
        this.validator = validator;
        this.executionStrategy = executionStrategy;
    }

    public double getPrice() {
        return price;
    }

    public Account getAccount() {
        return account;
    }

    public int getQuantity() {
        return quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public abstract void execute();
}