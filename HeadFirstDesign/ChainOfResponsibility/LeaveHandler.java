package HeadFirstDesign.ChainOfResponsibility;

public abstract class LeaveHandler {

    //successor
    protected LeaveHandler superVisor;

    //handle request

    public LeaveHandler(LeaveHandler superVisor) {
        this.superVisor = superVisor;
    }

    public void setSuperVisor(LeaveHandler superVisor) {
        this.superVisor = superVisor;
    }

    public abstract String applyLeave(Leave leave);
    
}
