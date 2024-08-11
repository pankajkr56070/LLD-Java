package HeadFirstDesign.Strategy;

public class Quack implements QuackInterface{

    @Override
    public void quack() {
        System.out.println("Normal duck quacking");
    }
}
