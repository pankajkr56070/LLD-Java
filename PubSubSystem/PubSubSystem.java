package PubSubSystem;

public class PubSubSystem {

    private static PubSubSystem instance;

    public static PubSubSystem getInstance() {
        if (instance == null) {
            instance = new PubSubSystem();
        }
        return instance;
    }
}
