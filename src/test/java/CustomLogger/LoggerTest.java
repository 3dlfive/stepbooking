package CustomLogger;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = new Logger();
    }
    @Test
    void testInfoWithParameter() throws IOException {
        String methodName = "testInfoWithParameter";
        String parameter = "paramValue";

        logger.info(parameter);

        String expectedLogMessage = methodName + " is called. Parametrs is : " + parameter;
        String actualLogMessage = getLastLogMessage();
        assertTrue(actualLogMessage.contains(expectedLogMessage));
    }

    @Test
    void testInfoWithoutParameter() throws IOException {
        String methodName = "testInfoWithoutParameter";

        logger.info();

        String expectedLogMessage = methodName + " is called.";
        String actualLogMessage = getLastLogMessage();
        assertTrue(actualLogMessage.contains(expectedLogMessage));
    }

    @Test
    void testErrorWithParameter() throws IOException {
        String methodName = "testErrorWithParameter";
        String parameter = "errorParam";

        logger.error(parameter);

        String expectedLogMessage = methodName + " exeption . Parametr is " + parameter;
        String actualLogMessage = getLastLogMessage();
        assertTrue(actualLogMessage.contains(expectedLogMessage));
    }

    @Test
    void testErrorWithoutParameter() throws IOException {
        String methodName = "testErrorWithoutParameter";

        logger.error();

        String expectedLogMessage = methodName;
        String actualLogMessage = getLastLogMessage();
        assertTrue(actualLogMessage.contains(expectedLogMessage));
    }

    private String getLastLogMessage() throws IOException {
        String logContent = Files.readString(Path.of("application.log"));
        String[] lines = logContent.split("\n");
        return lines[lines.length - 1].trim();
    }
}