package HeadFirstDesign.Decorator;

public class Espresso extends Beverage {

    @Override
    int cost() {
        System.out.println("Espresso");
        return 200;
    }
}
