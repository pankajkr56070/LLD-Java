package Logger;

public class Logger {
    private static Logger INSTANCE;
    private LogLevel logLevel;
    private LogSink logSink;

    Logger() {
        this.logLevel = LogLevel.INFO;
        this.logSink = new ConsoleLogSink();
    }

    public static Logger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Logger();
        }
        return INSTANCE;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void setLogSink(LogSink logSink) {
        this.logSink = logSink;
    }

    public void log(LogLevel level, String message) {
        if(logLevel.ordinal() <= level.ordinal()) {          
            logSink.log(message);
        }
    }
}
