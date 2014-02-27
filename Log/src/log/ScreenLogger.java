package log;

public class ScreenLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
