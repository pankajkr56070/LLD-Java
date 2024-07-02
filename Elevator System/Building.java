import java.util.List;

public class Building {

    private List<ElevatorCar> elevatorCarList;

    private List<Floor> floorList;


    private static Building building =  null;

    public static Building getInstance() {
        if(building == null) {
            building = new Building();
            
        }

        return building;
    }
    
}
