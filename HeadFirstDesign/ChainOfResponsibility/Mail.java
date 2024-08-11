package HeadFirstDesign.ChainOfResponsibility;

public abstract class Mail {
    protected Mail nextMail;

    public Mail(Mail mail) {
        this.nextMail = mail;//request.nextMail = Fan( fan.nextMail = null)
    }

    public void mailHandler(String mail) {
        if (nextMail == null) {
            System.out.println("i am doing nothing");
            return;
        }
        nextMail.mailHandler(mail);
    }
}
