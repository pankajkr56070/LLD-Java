import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Interface Segregation Principle (ISP) : Introducing interfaces can indeed help adhere to the Interface Segregation Principle (ISP),
// which states that clients should not be forced to depend on interfaces or methods they do not use.
public class PortfolioImpl implements Portfolio {
    private final Map<String, Integer> holdings;

    public PortfolioImpl() {
        this.holdings = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized void addStock(Stock stock, int quantity) {
        holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
    }

    @Override
    public synchronized void removeStock(Stock stock, int quantity) {
        String symbol = stock.getSymbol();
        if (holdings.containsKey(symbol)) {
            int currentQuantity = holdings.get(symbol);
            if (currentQuantity > quantity) {
                holdings.put(symbol, currentQuantity - quantity);
            } else if (currentQuantity == quantity) {
                holdings.remove(symbol);
            } else {
                throw new InsufficientStockException("Insufficient stock quantity in the portfolio.");
            }
        } else {
            throw new InsufficientStockException("Stock not found in the portfolio.");
        }
    }

    @Override
    public Map<String, Integer> getHoldings() {
        return holdings;
    }
}