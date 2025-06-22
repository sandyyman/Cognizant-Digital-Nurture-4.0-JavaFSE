public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger Instance 1: " + logger1);
        System.out.println("Logger Instance 2: " + logger2);
        System.out.println("Are both instances same? " + (logger1 == logger2));

        logger1.log("Application started.");
        logger2.log("Still using the same logger instance.");
    }
}
