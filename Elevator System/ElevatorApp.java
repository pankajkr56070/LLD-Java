/*
 * 1. Deisgn pattern:  
 * a) Strategy design pattern since the system could have multiple dispatch 
 *    request strategy classes. Therefore, depending on the particular layout of the building and 
 *    its scenarios, we choose a set of dispatch request strategy classes.
 *  b) State design pattern
 *  c) Delegation design pattern
 * 
 * 2. Follow up questions : Devise an algorithm to optimize any of these:    
 *      a) To minimize the wait time of the system
 *      b) To minimize the wait time of the passenger
 *      c) To maximize throughput
 *      d) To minimize the power usage or cost
 */

public class ElevatorApp {

    private Building building;

    public void monitoring() {
        System.out.println("Monitoring the elevators");
    }
    public void dispatcher() {
        System.out.println("Dispatching the best elevator");
    }

    // Private constructor to prevent direct instantiation
    private ElevatorApp() {
        // Initialize the ElevatorSystem
    }

    // The ElevarSystem is a singleton class that ensures it will have only one active instance at a time
    private static ElevatorApp system = null;


    // Created a static method to access the singleton instance of ElevatorSytem class
    public static ElevatorApp getInstance() {
        if (system == null) {
            system = new ElevatorApp();
        }
        return system;
    }

}
