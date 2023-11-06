package Flights.CollectionFlightDAO;

import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;

import java.util.ArrayList;

public class CollectionFlightDAO implements FlightDao {
    private ArrayList<Flight> flights;

    public CollectionFlightDAO(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public ArrayList<Flight> getAll() {
        return flights;
    }

    @Override
    public Flight getByID(int id) {
        return flights.stream().filter(x -> x.getFlightID() == id).toList().get(0);
    }
    @Override
    public void add(Flight flight) {
        flights.add(flight);
    }

    @Override
    public void dataToFile() {
        //todo
    }

    @Override
    public ArrayList<Flight> dataFromFile() {
        return null;//todo
    }
}
