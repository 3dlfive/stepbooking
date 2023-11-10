package Flights.Flight;

import Flights.Enums.Airline;
import Flights.Enums.Airport;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight implements Serializable {
    static final long serialVersionUID = 1;
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

    public Flight(){};

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
                "ID=" + flightID +
                ", airline=\'" + airline.label + "\'" +
                ", date=" + date +
                ", time=" + time +
                ", destination=\'" + destination + "\'" +
                ", emptySeats=" + emptySeats +
                "}");
    }

    public String serialize(){

        StringBuffer sb = new StringBuffer();
        sb.append(this.flightID);
        sb.append(" ");
        sb.append(this.date.getYear());
        sb.append("/");
        sb.append(this.date.getMonthValue());
        sb.append("/");
        sb.append(this.date.getDayOfMonth());
        sb.append(" ");
        sb.append(this.destination);
        sb.append(" ");
        sb.append(this.airline);
        sb.append(" ");
        sb.append(this.emptySeats);
        sb.append(" ");
        sb.append(this.time.getHour());
        sb.append("/");
        sb.append(this.time.getMinute());

        return sb.toString();
    }
    public static Flight deserialize(String in){
        ArrayList<String> parts = new ArrayList<>(List.of(in.split(" ")));
        ArrayList<String> date = new ArrayList<>(List.of(parts.get(1).split("/")));
        ArrayList<String> time = new ArrayList<>(List.of(parts.get(5).split("/")));
        Flight flight = new Flight(
                Integer.parseInt(parts.get(0)),
                LocalDate.of(Integer.parseInt(date.get(0)), Integer.parseInt(date.get(1)), Integer.parseInt(date.get(2))),
                Airport.valueOf(parts.get(2)),
                Airline.valueOf(parts.get(3)),
                Integer.parseInt(parts.get(4)),
                LocalTime.of( Integer.parseInt(time.get(0)), Integer.parseInt(time.get(1)) )
        );
        return flight;
    }
}
