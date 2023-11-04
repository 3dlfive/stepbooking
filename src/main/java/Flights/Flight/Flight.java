package Flights.Flight;

import Flights.Enums.Airline;
import Flights.Enums.Airport;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight{
    private int flightID;
    private LocalDate date;
    private Airport destination;
    private Airline airline;
    private int emptySeats;
    private LocalTime time;

    public Flight(int flightID, LocalDate date, Airport destination, Airline airline, int emptySeats, LocalTime time) {
        this.flightID = flightID;
        this.date = date;
        this.destination = destination;
        this.airline = airline;
        this.emptySeats = emptySeats;
        this.time = time;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getEmptySeats() {
        return emptySeats;
    }

    public void setEmptySeats(int emptySeats) {
        this.emptySeats = emptySeats;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString () {
        return( "Flight{"+
                "airline=\'" + airline.label + "\'" +
                ", date=" + date +
                ", time=" + time +
                ", destination=\'" + destination + "\'" +
                ", emptySeats=" + emptySeats +
                "}");
    }

    //public serialize(){
    //
    //}
    //public deserialize(){
    //
    //}
}
