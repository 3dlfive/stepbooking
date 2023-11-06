package CustomLogger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public void info(String message) {
        saveLogs(message, " [DEBUG] ");
    }

    public void error(String message) {
        saveLogs(message, " [ERROR] ");
    }

    public void saveLogs(String message, String mode) {
        LocalDateTime logtime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        StringBuffer sb = new StringBuffer();
        String timeStr = logtime.format(dateFormatter);
        sb.append("\n").append(timeStr).append(mode).append(message);
        try (RandomAccessFile file = new RandomAccessFile("application.log", "rw");
             FileChannel channel = file.getChannel();) {

            file.seek(file.length() - 1);
            ByteBuffer buffer = ByteBuffer.wrap(sb.toString().getBytes());
            channel.write(buffer);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
