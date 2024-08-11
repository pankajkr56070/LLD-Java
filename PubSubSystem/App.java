package PubSubSystem;

public class App {

    public static void main(String[] args) {
        PubSubSystem system = PubSubSystem.getInstance();

        Topic topic1 = new Topic("test-topic-1");
        Topic topic2 = new Topic("test-topic-2");

        Publisher publisher = new Publisher("test-publisher");

        publisher.registerTopic(topic1);
        publisher.registerTopic(topic2);

        Subscriber subscriber1 = new Subscriber("test-subscriber-1");
        Subscriber subscriber2 = new Subscriber("test-subscriber-2");

        topic1.subscribe(subscriber1);
        topic1.subscribe(subscriber2);

        Message message = new Message("Hi! how are you ?");

        publisher.publish(topic1, message);

        topic1.unsubscribe(subscriber2);
        topic2.subscribe(subscriber2);

        publisher.publish(topic2, message);


    }
}
