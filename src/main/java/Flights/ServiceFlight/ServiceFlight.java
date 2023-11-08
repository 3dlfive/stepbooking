package Flights.ServiceFlight;

import Flights.Enums.Airline;
import Flights.Enums.Airport;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ServiceFlight {
    private FlightDao db;

    public ServiceFlight(FlightDao db) {
        this.db = db;
    }

    public void generateFlights (int amount)
    {
        int sizeBefore = db.getAll().size();
        for(int i=sizeBefore; i<amount+sizeBefore; i++){
            db.add(new Flight(
                    i,
                    LocalDate.of(
                            (int)(Math.random() * 5 + 2023),
                            (int)(Math.random() * 12+1),
                            (int)(Math.random() * 28 +1)),
                    Arrays.asList(Airport.values()).get((int) (Math.random() * Airport.values().length)),
                    Arrays.asList(Airline.values()).get((int) (Math.random() * Airline.values().length)),
                    (int)(Math.random() * 301),
                    LocalTime.of((int)(Math.random() * 24),(int)(Math.random() * 60))
            ));
        }
    }
    // пошук рейсів за місцем призначення, датою і кількістю місць, яку треба забронювати
    public ArrayList<Flight> getSpecific(Airport dest, LocalDate date, int places) {
        ArrayList<Flight> list = new ArrayList<>(
                db.getAll().stream()
                .filter(x -> x.getDestination() == dest && x.getDate()==date && x.getEmptySeats() >= places)
                .toList()
        );
        return list;
    }
    public ArrayList<Flight> getAll(){
        return db.getAll();
    }
    public Flight getByID(int id){
        return db.getByID(id);
    }
    public void add(Flight flight){
        db.add(flight);
    }
    public void takeSeats(int flightId, int count){
        db.getByID(flightId).setEmptySeats( db.getByID(flightId).getEmptySeats() - count );
    } //віднімає count вільних місць у рейсу
    public void freeSeats(int flightId, int count){
        db.getByID(flightId).setEmptySeats( db.getByID(flightId).getEmptySeats() + count );
    } //додає count вільних місць рейсу
}
