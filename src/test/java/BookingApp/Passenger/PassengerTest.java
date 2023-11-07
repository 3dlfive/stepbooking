import BookingApp.Passenger.Passenger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testGetName() {
        Passenger passenger = new Passenger("John", "Doe");
        assertEquals("John", passenger.getName());
    }

    @Test
    public void testGetLastname() {
        Passenger passenger = new Passenger("Jane", "Smith");
        assertEquals("Smith", passenger.getLastname());
    }

    @Test
    public void testSetName() {
        Passenger passenger = new Passenger("Alice", "Johnson");
        passenger.setName("Bob");
        assertEquals("Bob", passenger.getName());
    }

    @Test
    public void testSetLastname() {
        Passenger passenger = new Passenger("Charlie", "Brown");
        passenger.setLastname("Davis");
        assertEquals("Davis", passenger.getLastname());
    }

    @Test
    public void testToString() {
        Passenger passenger = new Passenger("Alice", "Johnson");
        assertEquals("Passenger{name='Alice', lastname='Johnson'}", passenger.toString());
    }

    @Test
    public void testEquals() {
        Passenger passenger1 = new Passenger("John", "Doe");
        Passenger passenger2 = new Passenger("John", "Doe");
        Passenger passenger3 = new Passenger("Jane", "Smith");

        assertTrue(passenger1.equals(passenger2));
        assertFalse(passenger1.equals(passenger3));
    }

    @Test
    public void testHashCode() {
        Passenger passenger1 = new Passenger("John", "Doe");
        Passenger passenger2 = new Passenger("John", "Doe");
        Passenger passenger3 = new Passenger("Jane", "Smith");

        assertEquals(passenger1.hashCode(), passenger2.hashCode());
        assertNotEquals(passenger1.hashCode(), passenger3.hashCode());
    }
}
