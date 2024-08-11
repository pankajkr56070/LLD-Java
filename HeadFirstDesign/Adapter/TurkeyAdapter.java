package HeadFirstDesign.Adapter;


//Adapter implements the target interface and holds an instance of the Adaptee.
public class TurkeyAdapter implements Duck {

    //client
    private Turkey turkey;

    TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }

    }

    @Override
    public void quack() {
        turkey.gobble();

    }

}
