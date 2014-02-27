package log;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Writing to a file: " + message);
    }
}
