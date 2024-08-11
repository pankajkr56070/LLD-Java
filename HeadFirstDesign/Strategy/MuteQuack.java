package HeadFirstDesign.Strategy;

public class MuteQuack implements QuackInterface {

    public void quack() {
        System.out.println("I cant speak");
    }

}
