package Splitwise;

public class EqualSplit extends Split {
    public EqualSplit(IUser user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}