package Flights.ServiceFlight;

import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.Enums.Airline;
import Flights.Enums.Airport;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ServiceFlight {
    private FlightDao db;

    public ServiceFlight(FlightDao db) {
        this.db = db;
    }
    public ServiceFlight() {
        this.db = new CollectionFlightDAO(new ArrayList<>());
    }
    public void SetDao(CollectionFlightDAO dao){
        this.db = dao;
    }

    //methods
    public void generateFlights (int amount) {
        int sizeBefore = db.getAll().size();
        for(int i=sizeBefore; i<amount+sizeBefore; i++){
            db.add(new Flight(
                    i,
                    LocalDate.of(
                            LocalDate.now().getYear(),
                            LocalDate.now().getMonth(),
                            (int) (Math.random() * LocalDate.now().getMonth().length(LocalDate.now().isLeapYear()) + 1)),
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
                .filter(x -> (x.getDestination() == dest) && (x.getDate().equals(date)) && (x.getEmptySeats() >= places))
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
    public ArrayList<Flight> nextFlights(){
        ArrayList<Flight> list = new ArrayList<>(
                db.getAll().stream()
                        .filter(x ->
                                ( x.getDate().equals(LocalDate.now())
                                        && x.getTime().isAfter(LocalTime.now())) ||
                                        ( x.getDate().equals(LocalDate.now().plusDays(1))
                                                && x.getTime().isBefore(LocalTime.now())
                                        )
                        )
                        .toList()
        );
        return list;
    }
    public void takeSeats(int flightId, int count){
        db.getByID(flightId).setEmptySeats( db.getByID(flightId).getEmptySeats() - count );
    }
    public void freeSeats(int flightId, int count){
        db.getByID(flightId).setEmptySeats( db.getByID(flightId).getEmptySeats() + count );
    }

    public void saveToFile(){
        db.dataToFile();
    }
    public void loadFromFile() throws FileNotFoundException {
        db.dataFromFile();
    }
}
