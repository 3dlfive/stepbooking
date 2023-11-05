package Flights.FlightDAO;

import Flights.Flight.Flight;

import java.util.ArrayList;

public interface FlightDao {
    ArrayList<Flight> getAll();
    Flight getByID(int id);
    void add(Flight flight);
    void dataToFile();
    ArrayList<Flight> dataFromFile();
}
