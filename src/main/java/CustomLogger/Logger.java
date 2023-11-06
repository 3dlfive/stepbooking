package CustomLogger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public void info(String parametr) {

        String callerMethodName = getCallerMethodName();

        saveLogs(callerMethodName+" is called. Parametrs is : " + parametr, " [DEBUG] ");
    }
    public void info() {

        String callerMethodName = getCallerMethodName();

        saveLogs(callerMethodName+" is called.", " [DEBUG] ");
    }

    public void error(String parametr) {
        String callerMethodName = getCallerMethodName();
        saveLogs(callerMethodName + " exeption . Parametr is " + parametr, " [ERROR] ");
    }    public void error() {
        String callerMethodName = getCallerMethodName();
        saveLogs(callerMethodName, " [ERROR] ");
    }

    public void saveLogs(String message, String mode) {
        LocalDateTime logtime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        StringBuffer sb = new StringBuffer();
        String timeStr = logtime.format(dateFormatter);
        sb.append("\n").append(timeStr).append(mode).append(message);
        try (RandomAccessFile file = new RandomAccessFile("application.log", "rw");
             FileChannel channel = file.getChannel();) {
            if (file.length()!=0) {
                file.seek(file.length() - 1);
            }
            ByteBuffer buffer = ByteBuffer.wrap(sb.toString().getBytes());
            channel.write(buffer);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static String getCallerMethodName() {
        // Get the current stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // The first element in the stack trace is the getCallerMethodName method itself,
        // so we need to look at the second element to find the caller method.
        if (stackTrace.length >= 3) {
            StackTraceElement caller = stackTrace[3]; // Index 2 represents the caller method
            return caller.getMethodName();
        } else {
            return "Unknown";
        }
    }
}
