package Flights.ControllerFlight;

import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.Enums.Airline;
import Flights.Enums.Airport;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerFlightTest {
    FlightDao dao;
    ServiceFlight service;
    ControllerFlight testController;
    Flight f1;
    Flight f2;
    @BeforeEach
    void setup(){
        dao = new CollectionFlightDAO(new ArrayList<>());
        f1 = new Flight(
                1,
                LocalDate.of(1990, 10, 1),
                Airport.Augsburg,
                Airline.ACA,
                220,
                LocalTime.of(12, 30));
        f2 = new Flight(
                2,
                LocalDate.of(2000, 4, 7),
                Airport.Chicago,
                Airline.ANZ,
                50,
                LocalTime.of(9, 0)
        );
        dao.add(f1);
        dao.add(f2);
        service = new ServiceFlight(dao);
        testController = new ControllerFlight(service);
    }
    @Test
    void generateFlights() {
        testController.generateFlights(2);
        assertEquals(4, dao.getAll().size());
    }

    @Test
    void getSpecific() {
        ArrayList<Flight> expected = new ArrayList<>(List.of(f2));
        assertEquals(expected, testController.getSpecific(Airport.Chicago, LocalDate.of(2000,4,7), 3));
    }

    @Test
    void getAll() {
        ArrayList<Flight> expected = new ArrayList<>(List.of(f1, f2));
        assertEquals(expected, testController.getAll());
    }

    @Test
    void getByID() {
        Flight expected = f2;
        assertEquals(expected, testController.getByID(2));
    }

    @Test
    void add() {
        Flight f3 = new Flight(3,
                LocalDate.of(2001, 2, 2),
                Airport.Belley,
                Airline.ANZ,
                55,
                LocalTime.of(15, 25));
        testController.add(f3);

        ArrayList<Flight> expected = new ArrayList<>(List.of(f1, f2, f3));
        assertEquals(expected, testController.getAll());
    }

    @Test
    void takeSeats() {
        testController.takeSeats(1, 100);
        assertEquals(120, testController.getByID(1).getEmptySeats());
    }

    @Test
    void freeSeats() {
        testController.freeSeats(1, 100);
        assertEquals(320, testController.getByID(1).getEmptySeats());
    }

    @Test
    void saveToFile() {
        //todo
    }

    @Test
    void loadFromFile() {
        //todo
    }
}