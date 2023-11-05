package Flights.ControllerFlight;

import Flights.Flight.Flight;
import Flights.ServiceFlight.ServiceFlight;

import java.util.ArrayList;

public class ControllerFlight {
    private ServiceFlight fs;

    public ControllerFlight(ServiceFlight fs) {
        this.fs = fs;
    }

    public void generateFlights (int amount) //должно генерировать много
    {
        fs.generateFlights(amount);
    }
    public ArrayList<Flight> getAll(){
        return fs.getAll();
    }
    public Flight getByID(int id){
        return fs.getByID(id);
    }
    public void add(Flight flight){
        fs.add(flight);
    }
}
