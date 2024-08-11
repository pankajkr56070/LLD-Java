package ATMMachine;

public class AccountCreationFactory {

    public BankAccount createAccount(String accountType) {
        switch(accountType) :
             "SAVINGS" : return new SavingsAccout();
             "CURRENT" :  return new CurrentAccount();
        
    }
    
}
