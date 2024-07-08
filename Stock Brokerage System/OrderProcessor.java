
// Liskov Substitution Principle Check
// Ensure that wherever an Order object is expected, both BuyOrder and SellOrder
// can be used without altering the correctness of the program. This means that
// any operations or behaviors defined for Order should be consistent when using
// instances of BuyOrder or SellOrder.
public class OrderProcessor {
    public void processOrder(Order order) {
        order.execute();
    }
}