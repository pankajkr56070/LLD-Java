import enums.Directions;

public class Display {
   
    private int floor;
    private Directions direction;
    private int capacity;

    public void showElevatorDisplay() {
        System.out.println("Currently moving to  floor : 0");
    }
    public void showFloorDisplay() {
        System.out.println("Currently elevator at  floor : 1");
    }
}
