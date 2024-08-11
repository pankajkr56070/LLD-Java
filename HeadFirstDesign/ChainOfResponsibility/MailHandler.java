package HeadFirstDesign.ChainOfResponsibility;

public class MailHandler {
    private final String spam = "spam";
    private final String fan = "fan";
    private final String complaint = "complaint";
    private final String request = "request";

    public static void main(String[] args) {
        Mail mail = new Request(new Request(new Fan(null)));

        mail.mailHandler("fan nhi");
    }
}
