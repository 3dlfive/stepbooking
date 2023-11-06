package BookingApp.Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingControllerTest {
    BookingController bc = new BookingController();
    @Test
    void count() {
        assertEquals(bc.count(),0);

    }
}