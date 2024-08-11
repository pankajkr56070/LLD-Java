package Logger;

public class ConsoleLogSink implements LogSink {

    @Override
    public void log(String message) {
       System.out.println(message);
    }

}
