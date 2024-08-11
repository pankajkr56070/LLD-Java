package HeadFirstDesign.Factory;


public class NYStylePizzaStore extends PizzaStore {
    //A factory method handles object creation and encapsulates it in a
    //subclass. This decouples the client code in the superclass from the
    //object creation code in the subclass.
    @Override
    public Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
            } else if (item.equals("veggie")) {
            return new NYStyleVeggiePizza();
            } else if (item.equals("clam")) {
            return new NYStyleClamPizza();
            } else if (item.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
            } else return null;
    }

}
