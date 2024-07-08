public abstract class Order {
    protected final String orderId;
    protected final Account account;
    protected final Stock stock;
    protected final int quantity;
    protected final double price;
    protected OrderStatus status;

    public Order(String orderId, Account account, Stock stock, int quantity, double price) {
        validateInputs(quantity, price);
        this.orderId = orderId;
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.status = OrderStatus.PENDING;
    }

    private void validateInputs(int quantity, double price) {
        if (quantity <= 0) {
            throw new InvalidInputException("Quantity must be positive.");
        }
        if (price <= 0) {
            throw new InvalidInputException("Price must be positive.");
        }
    }

    public abstract void execute();
}