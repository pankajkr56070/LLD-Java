import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class StockBroker {
    private static StockBroker instance;
    private final Map<String, Account> accounts;
    private final Map<String, Stock> stocks;
    // Using a thread pool can lead to orders being executed out of sequence since
    // threads run concurrently. To ensure that orders are processed in the order
    // they are placed while still utilizing multiple threads, you can use a
    // BlockingQueue and a single-threaded executor to maintain order. Each order
    // can be processed by separate threads while still ensuring the original order
    // of execution.
    private final BlockingQueue<Order> orderQueue;
    private final AtomicInteger accountIdCounter;
    // To achieve non-blocking order processing using a separate thread or a thread
    // pool, we can leverage Java's concurrency utilities, specifically the
    // ExecutorService. This allows us to process orders asynchronously and handle
    // multiple orders concurrently, improving the responsiveness and scalability of
    // your system.
    private final ExecutorService executorService;

    private StockBroker() {
        accounts = new ConcurrentHashMap<>();
        stocks = new ConcurrentHashMap<>();
        orderQueue = new LinkedBlockingQueue<>();
        accountIdCounter = new AtomicInteger(1);
        executorService = Executors.newSingleThreadExecutor(); // Single-threaded executor to ensure order
    }

    public static synchronized StockBroker getInstance() {
        if (instance == null) {
            instance = new StockBroker();
        }
        return instance;
    }

    public void createAccount(User user, double initialBalance) {
        String accountId = generateAccountId();
        Portfolio portfolio = new PortfolioImpl();
        Account account = new AccountImpl(accountId, user, initialBalance, portfolio);
        accounts.put(accountId, account);
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    public void placeOrder(Order order) {
        orderQueue.offer(order);
        processOrders();
    }

    private void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            executorService.submit(() -> {
                try {
                    order.execute();
                } catch (InsufficientFundsException | InsufficientStockException e) {
                    // Handle exception and notify user
                    System.out.println("Order failed: " + e.getMessage());
                }
            });
        }
    }

    private String generateAccountId() {
        int accountId = accountIdCounter.getAndIncrement();
        return "A" + String.format("%03d", accountId);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}