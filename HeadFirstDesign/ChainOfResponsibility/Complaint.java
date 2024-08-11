package HeadFirstDesign.ChainOfResponsibility;

import java.util.Objects;

public class Complaint extends  Mail {
    public Complaint(Mail mail) {
        super(mail);
    }

    public void mailHandler(String mail) {
        if(Objects.equals(mail, "complaint")) {
            System.out.println("going to complain box");
        } else {
            super.mailHandler(mail);
        }
    }
}
