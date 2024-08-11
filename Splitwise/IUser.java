package Splitwise;

import java.util.Map;

public interface IUser {
    String getId();
    String getName();
    Map<String, Double> getBalances();
    void updateBalance(String userId, double amount);
}
