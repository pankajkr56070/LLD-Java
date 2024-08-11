package Splitwise;

public abstract class Split implements ISplit{
    protected IUser user;
    protected double amount;

    public Split(IUser user) {
        this.user = user;
    }

    public abstract double getAmount();

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public IUser getUser() {
        return user;
    }
}
