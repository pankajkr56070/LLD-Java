package HeadFirstDesign.Decorator;

public class DarkRoast extends Beverage {

    @Override
    int cost() {
        System.out.println("Dark roast");
        return 50;
    }

}
