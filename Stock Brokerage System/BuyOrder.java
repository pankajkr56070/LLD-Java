//Liskov Substitution Principle (LSP) : To ensure that BuyOrder and SellOrder can be used interchangeably with Order without unexpected behavior, 
// we need to adhere to the Liskov Substitution Principle (LSP). This principle ensures that subclasses (derived classes) 
//should behave in such a way that they can replace instances of their base class without affecting the correctness of the program.

//Here's how you can ensure LSP compliance for BuyOrder and SellOrder:
public class BuyOrder extends Order {
    public BuyOrder(String orderId, Account account, Stock stock, int quantity, double price,
            OrderValidator validator, OrderExecutionStrategy strategy) {
        super(orderId, account, stock, quantity, price, validator, strategy);
    }

    @Override
    public void execute() {
        strategy.execute();
        // Additional logic specific to Buy Order if needed
    }
}