package Splitwise;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Splitwise {
    private static Splitwise instance;
    private final Map<String, User> users;
    private final Map<String, Group> groups;

    private static final String TRANSACTION_ID_PREFIX = "TXN";
    private static final AtomicInteger transactionCounter = new AtomicInteger(0);

    private Splitwise() {
        users = new ConcurrentHashMap<>();
        groups = new ConcurrentHashMap<>();
    }

    public static synchronized Splitwise getInstance() {
        if (instance == null) {
            instance = new Splitwise();
        }
        return instance;
    }


    public void addUser(User user) {
        users.put(user.getId(), user);
       
    }

    public void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    public void addTransaction(String groupId, Transaction transaction) {
        Group group = groups.get(groupId);
        if (group != null) {
            group.addTransaction(transaction);
            splitExpense(transaction);
            updateBalances(transaction);
        }
       
    }

    private void updateBalances(Transaction transaction) {
       System.out.println("Updating balance for transaction : " + transaction.getId());
    }

    private void splitExpense(Transaction transaction) {
        System.out.println("Splititng expense for transaction : " + transaction.getId());
    }

    public void settleBalance(User user1, User user2) {
        System.out.println("Settling balance among user " + user1.getId() + "and user " + user2.getId());
    }

}
