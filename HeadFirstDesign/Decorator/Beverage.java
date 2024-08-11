package HeadFirstDesign.Decorator;

public abstract class Beverage {

    String description;

    abstract int cost();

    public String getDescription() {
        return description;
    }    

}
