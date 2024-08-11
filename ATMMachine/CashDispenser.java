package ATMMachine;

abstract class CashDispenser {

    protected CashDispenser nextDispenser;

    public abstract void dispense(int amount);
    
}


class FiveHundredNotesDispenser extends CashDispenser {
    @Override
    public void dispense(int amount) {
        if (amount <= 0) {
            return;
        }

        int numNotes = amount / 500;
        int remainder = amount % 500;

        // operation to dispense numNotes

        this.nextDispenser.dispense(remainder);
    }
} 

class TwoHundredNotesDispenser extends CashDispenser {
    @Override
    public void dispense(int amount) {
        if (amount <= 0) {
            return;
        }

        int numNotes = amount / 200;
        int remainder = amount % 200;

        // operation to dispense numNotes

        this.nextDispenser.dispense(remainder);
    }
} 
