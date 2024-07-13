package Splitwise;

import java.util.Arrays;
import java.util.Map;

public class Demo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Splitwise splitwise = Splitwise.getInstance();

        // create users
        User user1 = new User("1", "Pankaj",  "xyz@gmail.com");
        User user2 = new User("2", "Joe",  "abc@gmail.com");
        User user3 = new User("3", "Alice",  "pan@gmail.com");

        //add users
        splitwise.addUser(user1);
        splitwise.addUser(user2);
        splitwise.addUser(user3);


        //create a group
        Group group1 = new Group("1" , "Flat");
       
        //add users to group
        group1.addMember(user1);
        group1.addMember(user2);
        group1.addMember(user3);

        //add group
        splitwise.addGroup(group1);

        //create a transaction
        Transaction transaction = new Transaction("1", 250.6, "snacks", user1);
        EqualSplit equalSplit1 = new EqualSplit(user1);
        EqualSplit equalSplit2 = new EqualSplit(user2);
        PercentageSplit percentageSplit = new PercentageSplit(user3, 20.0);

        transaction.addSplit(equalSplit1);
        transaction.addSplit(equalSplit2);
        transaction.addSplit(percentageSplit);

        splitwise.addTransaction(group1.getId(), transaction);

        splitwise.settleBalance(user1, user2);
        splitwise.settleBalance(user1, user3);

        for (User user : Arrays.asList(user1, user2, user3)) {
            System.out.println("User: " + user.getName());
            for (Map.Entry<String, Double> entry : user.getBalances().entrySet()) {
                System.out.println("  Balance with " + entry.getKey() + ": " + entry.getValue());
            }
        }

    } 

}
