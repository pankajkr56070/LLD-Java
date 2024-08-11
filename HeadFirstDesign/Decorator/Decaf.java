package HeadFirstDesign.Decorator;

public class Decaf extends Beverage {

    @Override
    int cost() {
        System.out.println("Decaf");
        return 100;
    }



}
