package HeadFirstDesign.ChainOfResponsibility;

import java.util.Objects;

public class Request extends Mail {

    public Request(Mail mail) {
        super(mail);
    }

    public void mailHandler(String mail) {
        if (Objects.equals(mail, "request")) {
            System.out.println("going to request box");
        } else {
            super.mailHandler(mail);
        }
    }
}
