package Flights.ControllerFlight;

import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.Enums.Airline;
import Flights.Enums.Airport;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
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
    void dataToFile(){
        File f = new File("Flights.txt");
        if (f.exists()) f.delete();
        testController.saveToFile();
        ArrayList<String> expected;
        ArrayList<String> actual;

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            expected = new ArrayList<>();
            expected.add("1 1990/10/1 Augsburg ACA 220 12/30");
            expected.add("2 2000/4/7 Chicago ANZ 50 9/0");
            actual = new ArrayList<>();
            while(true) {
                String line = br.readLine();
                if (line == null) break;
                actual.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(expected, actual);
    }

    @Test
    void dataFromFile() {
        File f = new File("Flights.txt");
        if (f.exists()) f.delete();
        testController.clear();
        try {
            FileWriter fr = new FileWriter(f);
            fr.write("1 1990/10/1 Augsburg ACA 220 12/30\r\n");
            fr.write("1 1990/10/1 Augsburg ACA 220 13/40\r\n");
            fr.close();
            testController.loadFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Flight> expected = new ArrayList<>(List.of(
                new Flight(
                        1,
                        LocalDate.of(1990, 10, 1),
                        Airport.Augsburg,
                        Airline.ACA,
                        220,
                        LocalTime.of(12, 30)),
                new Flight(
                        1,
                        LocalDate.of(1990, 10, 1),
                        Airport.Augsburg,
                        Airline.ACA,
                        220,
                        LocalTime.of(13, 40))
        ));

        ArrayList<Flight> actual = testController.getAll();

        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    void clear() {
        testController.clear();
        ArrayList<Flight> expected = new ArrayList<>();
        assertEquals(expected.toString(), testController.getAll().toString());
    }
}
