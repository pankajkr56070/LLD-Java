public class Demo {
    /**@param <StockBroker>
     * @param <User>
     * 
     * 
     */
    public static  void main() {
        //System -  singleton pattern
        StockBroker stockBroker = StockBroker.getInstance();

        //Actors
        // Create user and account
        User user = new User("A001", "John Doe", "john@example.com");
        stockBroker.createAccount(user, 10000.0);
        Account account = stockBroker.getAccount("A001");

        // Add stocks to the stock broker
        Stock stock1 = new Stock("AAPL", "Apple Inc.", 150.0);
        Stock stock2 = new Stock("GOOGL", "Alphabet Inc.", 2000.0);
        stockBroker.addStock(stock1);
        stockBroker.addStock(stock2);

        // Place buy orders
        Order buyOrder1 = new BuyOrder("O001", account, stock1, 0, 150);
        Order buyOrder2 = new BuyOrder("O002", account, stock2, 5, 2000.0);
        stockBroker.placeOrder(buyOrder1);
        stockBroker.placeOrder(buyOrder2);

        // Place sell orders
        Order sellOrder1 = new SellOrder("O003", account, stock1, 5, 160.0);
        stockBroker.placeOrder(sellOrder1);

        // Wait for a while to let orders process (for demo purposes)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print account balance and portfolio
        System.out.println("Account Balance: $" + account.getBalance());
        System.out.println("Portfolio: " + account.getPortfolio().getHoldings());
        Stock stock3 = new Stock("TSLA", "TESLA", 300.0);
        account.getPortfolio().removeStock(stock3, 5);;

        // Shutdown executor service : Ensures the ExecutorService is properly shut down, releasing resources.
        stockBroker.shutdown();
    }
}
