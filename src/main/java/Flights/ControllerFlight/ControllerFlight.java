package Flights.ControllerFlight;

import Flights.Enums.Airport;
import Flights.Flight.Flight;
import Flights.ServiceFlight.ServiceFlight;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerFlight {
    private ServiceFlight fs;
    public ControllerFlight(ServiceFlight fs) {
        this.fs = fs;
    }

    //methods
    public void generateFlights (int amount) {
        fs.generateFlights(amount);
    }
    public ArrayList<Flight> getSpecific(Airport dest, LocalDate date, int places) {
        return fs.getSpecific(dest, date, places);
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
    public void takeSeats(int flightId, int count){
        fs.takeSeats(flightId, count);
    } // віднімає count вільних місць у рейсу
    public void freeSeats(int flightId, int count){
        fs.freeSeats(flightId, count);
    } // додає count вільних місць рейсу

    public void saveToFile(){
        fs.saveToFile();
    }
    public void loadFromFile(){
        fs.loadFromFile();
    }
}
