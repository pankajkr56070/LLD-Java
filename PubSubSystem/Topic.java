package PubSubSystem;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String name;
    // Violates OCP as subscribing to multiple subscribers would require modification.
    // How to fix : Creating list of subscribers to fix this
    private List<Subscriber> subscribers = new ArrayList<>();

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void push(Message message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.consume(message);
        }
    }
}
