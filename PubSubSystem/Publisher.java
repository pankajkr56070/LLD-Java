package PubSubSystem;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private final String name;
    private final List<Topic> topics = new ArrayList<>();

    public Publisher(String name) {
        this.name = name;
    }

    public void registerTopic(Topic topic) {
        topics.add(topic);
    }

    public void publish(Topic topic, Message message) {
        System.out.println("Publisher " + name + " pushing message " + message.getData() + " to topic " + topic.getName());
        topic.push(message);
    }
}
