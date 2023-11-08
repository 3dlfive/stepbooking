package Flights.Flight;

import Flights.Enums.Airline;
import Flights.Enums.Airport;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    Flight testData = new Flight(
            1,
            LocalDate.of(1990, 10, 1),
            Airport.Augsburg,
            Airline.ACA,
            220,
            LocalTime.of(12, 30)
    );

    @Test
    void getFlightID() {
        assertEquals(testData.getFlightID(), 1);
    }

    @Test
    void setFlightID() {
        testData.setFlightID(2);
        assertEquals(testData.getFlightID(), 2);
    }

    @Test
    void getDate() {
        assertEquals(testData.getDate(), LocalDate.of(1990, 10, 1));
    }

    @Test
    void setDate() {
        testData.setDate(LocalDate.of(2000,12,2));
        assertEquals(testData.getDate(), LocalDate.of(2000, 12, 2));
    }

    @Test
    void getDestination() {
        assertEquals(testData.getDestination(), Airport.Augsburg);
    }

    @Test
    void setDestination() {
        testData.setDestination(Airport.Berlin);
        assertEquals(testData.getDestination(), Airport.Berlin);
    }

    @Test
    void getAirline() {
        assertEquals(testData.getAirline(), Airline.ACA);
    }

    @Test
    void setAirline() {
        testData.setAirline(Airline.AAL);
        assertEquals(testData.getAirline(), Airline.AAL);
    }

    @Test
    void getEmptySeats() {
        assertEquals(testData.getEmptySeats(), 220);
    }

    @Test
    void setEmptySeats() {
        testData.setEmptySeats(100);
        assertEquals(testData.getEmptySeats(), 100);
    }

    @Test
    void getTime() {
        assertEquals(testData.getTime(), LocalTime.of(12, 30));
    }

    @Test
    void setTime() {
        testData.setTime(LocalTime.of(2, 10));
        assertEquals(testData.getTime(), LocalTime.of(2, 10));
    }

    @Test
    void testToString() {
        Flight f = new Flight(
                1,
                LocalDate.of(1990, 10, 1),
                Airport.Augsburg,
                Airline.ACA,
                220,
                LocalTime.of(12, 30)
        );
        String expected = "Flight{airline='AIR CANADA', date=1990-10-01, time=12:30, destination='Augsburg', emptySeats=220}";
        assertEquals(expected, f.toString());
    }

    @Test
    void serialize() {
        Flight f = new Flight(
                1,
                LocalDate.of(1990, 10, 1),
                Airport.Augsburg,
                Airline.ACA,
                220,
                LocalTime.of(12, 30)
        );
        String expected = "1 1990/10/1 Augsburg ACA 220 12/30";
        assertEquals(expected, f.serialize());
    }

    @Test
    void deserialize() {
        String in = "1 1990/10/1 Augsburg ACA 220 12/30";

        Flight expected = new Flight(
                1,
                LocalDate.of(1990, 10, 1),
                Airport.Augsburg,
                Airline.ACA,
                220,
                LocalTime.of(12, 30)
        );

        assertEquals(expected.toString(), Flight.deserialize(in).toString());
    }
}