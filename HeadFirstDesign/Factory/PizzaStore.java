package HeadFirstDesign.Factory;

public abstract class PizzaStore {
    // this code is not closed for modification if we have to add more pizza types
    // which concrete class is to be instantiated
    // what is varying here - pizza type
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;

    }
    //All the responsibility for instantiating Pizzas has been moved into a method that acts as a factory.
    protected abstract Pizza createPizza(String type);

}
