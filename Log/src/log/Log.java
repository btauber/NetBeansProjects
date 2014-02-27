package log;

public class Log {
    private Logger logger = new ScreenLogger();
    
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    
    public void log(String message){
        logger.log(message);
    }
}
