package HeadFirstDesign.ChainOfResponsibility;

import java.util.Objects;

public class Fan extends Mail {

    Fan(Mail mail) {
        super(mail);
    }

    public void mailHandler(String mail) {
        if (Objects.equals(mail, "fan")) {
            System.out.println("going to ceo");
        } else {
            super.mailHandler(mail);
        }
    }


}
