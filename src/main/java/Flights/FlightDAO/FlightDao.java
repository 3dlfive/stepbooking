package Flights.FlightDAO;

import Flights.Flight.Flight;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface FlightDao {
    ArrayList<Flight> getAll();
    Flight getByID(int id);
    void add(Flight flight);
    void dataToFile();
    void dataFromFile() throws FileNotFoundException;
}
