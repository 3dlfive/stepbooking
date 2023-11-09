package table;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    @Test
    public void testTellHim() {
        // Arrange
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        Console console = new Console();
        Console.TellHim("1");

        // Assert
        assertEquals("1", out.toString().trim());
    }


    @Test
    public void testAskHim() {
        // Подготавливаем фиктивный ввод
        String input = "1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Вызываем метод, который должен считать ввод и вернуть его
        String result = Console.askHim("1");

        // Проверяем, что результат соответствует ожидаемому вводу
        assertEquals(input, result);
    }
    @Test
    public void testReadLine() {
        // Подготавливаем фиктивный ввод
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Вызываем метод, который должен считать ввод и вернуть его
        String result = Console.readLine();

        // Проверяем, что результат соответствует ожидаемому вводу
        assertEquals(input, result);
    }

}

