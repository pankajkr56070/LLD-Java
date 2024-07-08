
public class OrderValidator {

    public void validateOrder(Order order) {
        if (order.getQuantity() <= 0 || order.getPrice() <= 0) {
            throw new IllegalArgumentException("Quantity and price must be positive for buy orders.");
        }
        if (order.getAccount().getBalance() < order.getQuantity() * order.getPrice()) {
            throw new InsufficientFundsException("Insufficient funds to execute the buy order.");
        }
    }
}
