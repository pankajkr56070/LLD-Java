package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSink implements LogSink {

    private String filename;

    public FileSink(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
