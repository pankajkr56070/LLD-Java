package Splitwise;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User implements IUser {
    private final String id;
    private final String name;
    private final String email;
    private final Map<String, Double> balances;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balances = new ConcurrentHashMap<>();
    }

    public String getName() {
       return name;
    }

    public Map<String, Double> getBalances() {
        return balances;
    }

    public String getId() {
       return id;
    }

    public void updateBalance(String userId, double amount) {
        balances.put(userId, balances.getOrDefault(userId, 0.0) + amount);
    }

}
