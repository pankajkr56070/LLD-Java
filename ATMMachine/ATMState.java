package ATMMachine;


// State design pattern
public interface ATMState {

    void insertCard();

    void authenticatePin();

    void selectOperation();

    void withdrawCash();

    void displayBalance();

    void transferMoney();

    void returnCard();
    
} 

class IdleState implements ATMState {
    private ATM atm;

    @Override
    public void insertCard() {
        // operation

        atm.setCurrentState(new CardInsertedState());
    }
}

class CardInsertedState implements ATMState {
    private ATM atm;


    @Override
    public void selectOperation() {
        // operation

        atm.setCurrentState(new CheckBalanceState(atm));
    }
}
