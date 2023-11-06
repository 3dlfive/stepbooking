package BookingApp.Booking;

import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.ControllerFlight.ControllerFlight;
import Flights.Flight.Flight;
import Flights.ServiceFlight.ServiceFlight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking<Flight> case1;
    Booking<Flight> case2;
    Booking<Flight> case3;
    Booking<Flight> case4;
    Booking<Flight> case5;
    @BeforeEach

    void setup(){
        ControllerFlight fc = new ControllerFlight(new ServiceFlight(new CollectionFlightDAO(new ArrayList<>())));
        fc.generateFlights(15);

        case1 = new Booking<>(fc.getByID(1),"Benita","Bradberry",5);
        case2 = new Booking<>(fc.getByID(2),"Vera","Hendricks",2);
        case3 = new Booking<>(fc.getByID(3),"Keturah","Persons",3);
        case4 = new Booking<>(fc.getByID(4),"Morrel","Brimmer",3);
        case5 = new Booking<>(fc.getByID(5),"Korri","Ofarrell",5);
    }
    @Test
    @DisplayName("Test that to object have diffrent UID")
    void getUniqueID() {

        assertNotEquals(case1.getUniqueID(),case2.getUniqueID());
    }



    @Test
    void getName() {
        assertEquals(case1.getName(),"Benita");
    }

    @Test
    void setName() {
        case1.setName("Diana");
        assertEquals(case1.getName(),"Diana");

    }

    @Test
    void getLastname() {
        assertEquals(case1.getLastname(),"Bradberry");

    }

    @Test
    void setLastname() {
        case2.setLastname("Ofarrell");
        assertEquals(case2.getLastname(),"Ofarrell");
    }

    @Test
    void getTicketsAmount() {
        assertEquals(case1.getTicketsAmount(),5);
    }

    @Test
    void setTicketsAmount() {
        case2.setTicketsAmount(1);
        assertEquals(case2.getTicketsAmount(),1);
    }

    @Test

    void testNotEquals() {
        assertNotEquals(case1, case2);
    }

}