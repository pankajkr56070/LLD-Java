import java.util.Map;

public interface Portfolio {

    void addStock(Stock stock, int quantity);

    void removeStock(Stock stock, int quantity);

    Map<String, Integer> getHoldings();
}
