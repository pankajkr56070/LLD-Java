package HeadFirstDesign.ChainOfResponsibility;

import java.util.Objects;

public class Spam  extends  Mail{
    public Spam(Mail mail) {
        super(mail);
    }

    public void mailHandler(String mail) {
        if(Objects.equals(mail, "spam")) {
            System.out.println("going to spam folder");
        } else {
            super.mailHandler(mail);
        }
    }
}
