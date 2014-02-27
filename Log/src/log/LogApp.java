package log;

import java.util.Random;

public class LogApp {
    private static Log logger = new Log();
    
    public static void main(String[] args) {
        logger.setLogger(new FileLogger());
        
        int x = new Random().nextInt(2000);
        logger.log("x is " + x);
    }
}
