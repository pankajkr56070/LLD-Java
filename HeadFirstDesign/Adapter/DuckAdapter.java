package HeadFirstDesign.Adapter;

import java.util.Random;

public class DuckAdapter implements Turkey {
    private Duck duck;

    DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void fly() {
        if (new Random().nextInt(5) == 0) {
            duck.fly();
        }    
    }

    @Override
    public void gobble() {
       duck.quack();
        
    }
    

}
