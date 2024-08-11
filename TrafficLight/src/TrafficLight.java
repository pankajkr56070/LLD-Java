import java.util.HashMap;
import java.util.Random;

public class TrafficLight {

    public TrafficLight() {

    }

    public void carArrived() {

        HashMap<Long, Long> bigMap = new HashMap<>();
        Random r = new Random();
        // size map : key collision probability increases
        // memory increase with each iteration  : Java GC kick in slow performance
        for (long i = 0; i < 100L * 100L * 100L; i++) {
            long key = r.nextLong();
            long val = r.nextLong();
            bigMap.put(key, val);
        }

    }
}
