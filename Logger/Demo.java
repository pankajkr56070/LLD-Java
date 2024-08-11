package Logger;

public class Demo {

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        logger.setLogLevel(LogLevel.INFO);
        logger.setLogSink(new ConsoleLogSink());


        logger.log(LogLevel.INFO, "This is an info message");
        logger.log(LogLevel.WARN, "This is a warning message");
        logger.log(LogLevel.ERROR, "This is an error message");

        // Using FileLogSink
        logger.setLogSink(new FileSink("log.txt"));

        logger.log(LogLevel.INFO, "Logging to a file");
    }

}
