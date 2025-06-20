public class Logger {
    // Static instance of the same class
    private static Logger instance;

    // Private constructor to prevent external instantiation
    private Logger() {
        System.out.println("Logger created!");
    }

    // Static method to return the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
