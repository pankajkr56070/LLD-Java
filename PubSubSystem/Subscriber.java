package PubSubSystem;

public class Subscriber {
    String name;
    public Subscriber(String name) {
        this.name = name;
    }

    public void consume(Message message) {
        System.out.println(name + " consuming message " + message.getData());
    }
}
