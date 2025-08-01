package slf4j_logging.exercise_1_logging_levels;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("This is an informational message.");
        logger.warn("⚠️ Warning: This is a warning message.");
        logger.error("❌ Error: Something went wrong.");
    }
}
