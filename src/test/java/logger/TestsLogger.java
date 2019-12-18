package logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class TestsLogger {
    private static final Logger logger = Logger.getLogger("TESTS");

    static {
        BasicConfigurator.configure();
    }

    public static void info(String message) {
        logger.info(message);
    }
}
