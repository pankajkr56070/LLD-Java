package HeadFirstDesign.ChainOfResponsibility;

public class Demo {

    public static void main(String[] args) {
        
        LeaveHandler request = new TeamLeader(new ProjectLeader(new HR(new Manager(null))));

        Leave leave1 = new Leave(5,4, ReasonType.REGULAR);
        System.out.println(request.applyLeave(leave1));

        Leave leave2 = new Leave(5,5, ReasonType.REGULAR);
        System.out.println(request.applyLeave(leave2));

        Leave leave3 = new Leave(12,3, ReasonType.REGULAR);
        System.out.println(request.applyLeave(leave3));

        Leave leave4 = new Leave(18,2, ReasonType.CRITICAL);
        System.out.println(request.applyLeave(leave4));

        Leave leave5 = new Leave(18,2, ReasonType.REGULAR);
        System.out.println(request.applyLeave(leave5));

        Leave leave6 = new Leave(30,2, ReasonType.SPECIAL);
        System.out.println(request.applyLeave(leave6));
    }

}
