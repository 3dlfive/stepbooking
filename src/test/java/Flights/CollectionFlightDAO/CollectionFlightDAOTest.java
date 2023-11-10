package Flights.CollectionFlightDAO;

import Flights.ControllerFlight.ControllerFlight;
import Flights.Enums.Airline;
import Flights.Enums.Airport;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionFlightDAOTest {
    FlightDao testDao;
    @BeforeEach
    void setup(){
        testDao = new CollectionFlightDAO(new ArrayList<>(List.of(
                new Flight(
                        1,
                        LocalDate.of(1990, 10, 1),
                        Airport.Augsburg,
                        Airline.ACA,
                        220,
                        LocalTime.of(12, 30)),
                new Flight(
                        2,
                        LocalDate.of(2000, 4, 7),
                        Airport.Chicago,
                        Airline.ANZ,
                        50,
                        LocalTime.of(9, 0)
                )
        )));
    }
    @Test

    void getAll() {
        ArrayList<Flight> expected = new ArrayList<>();
        Flight f1 = new Flight(
                1,
                LocalDate.of(1990, 10, 1),
                Airport.Augsburg,
                Airline.ACA,
                220,
                LocalTime.of(12, 30));
        Flight f2 = new Flight(
                2,
                LocalDate.of(2000, 4, 7),
                Airport.Chicago,
                Airline.ANZ,
                50,
                LocalTime.of(9, 0)
        );
        expected.add(f1);
        expected.add(f2);
        assertEquals(expected.toString(), testDao.getAll().toString());
    }

    @Test
    void getByID() {
        Flight expected = new Flight(
                1,
                LocalDate.of(1990, 10, 1),
                Airport.Augsburg,
                Airline.ACA,
                220,
                LocalTime.of(12, 30));
        assertEquals(expected.toString(), testDao.getByID(1).toString());
    }

    @Test
    void add() {
        ArrayList<Flight> expected = new ArrayList<>();
        Flight f1 = new Flight(
                1,
                LocalDate.of(1990, 10, 1),
                Airport.Augsburg,
                Airline.ACA,
                220,
                LocalTime.of(12, 30));
        Flight f2 = new Flight(
                2,
                LocalDate.of(2000, 4, 7),
                Airport.Chicago,
                Airline.ANZ,
                50,
                LocalTime.of(9, 0)
        );
        Flight f3 = new Flight(
                3,
                LocalDate.of(2010, 5, 1),
                Airport.Belley,
                Airline.COA,
                500,
                LocalTime.of(10, 0)
        );
        expected.add(f1);
        expected.add(f2);
        expected.add(f3);
        testDao.add(f3);
        assertEquals(expected.toString(), testDao.getAll().toString());
    }

    @Test
    void dataToFile(){
        File f = new File("Flights.txt");
        if (f.exists()) f.delete();
        testDao.dataToFile();
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
        testDao.clear();
        try {
            FileWriter fr = new FileWriter(f);
            fr.write("1 1990/10/1 Augsburg ACA 220 12/30\r\n");
            fr.write("1 1990/10/1 Augsburg ACA 220 13/40\r\n");
            fr.close();
            testDao.dataFromFile();
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

        ArrayList<Flight> actual = testDao.getAll();

        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    void clear() {
        testDao.clear();
        ArrayList<Flight> expected = new ArrayList<>();
        assertEquals(expected.toString(), testDao.getAll().toString());
    }
}