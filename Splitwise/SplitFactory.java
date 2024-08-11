package Splitwise;

public class SplitFactory {
    public static ISplit createSplit(String type, IUser user, double value) {
        switch (type) {
            case "EQUAL":
                return new EqualSplit(user);
            case "PERCENTAGE":
                return new PercentageSplit(user, value);
            default:
                throw new IllegalArgumentException("Invalid split type");
        }
    }
}