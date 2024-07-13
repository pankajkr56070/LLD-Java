package Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group {
    private final String id;
    private final String name;
    private final List<User> members;
    private final List<Transaction> expenses;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public String getId() {
        return id;
    }

    public void addTransaction(Transaction transaction) {
        expenses.add(transaction);
    }

}
