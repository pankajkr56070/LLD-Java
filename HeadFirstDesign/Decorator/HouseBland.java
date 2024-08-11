package HeadFirstDesign.Decorator;

public class HouseBland extends Beverage {

    @Override
    int cost() {      
       System.out.println("House Blandt");
       return 20;
    }


}
