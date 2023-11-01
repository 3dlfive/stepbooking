package BookingApp.Booking;

import java.util.ArrayList;

public class Booking<T> {
    private T flight;
    private String name;
    private String lastname;
    private int ticketsAmount;

    public Booking(T flight, String name, String lastname, int ticketsAmount) {
        setFlight(flight);
        setName(name);
        setLastname(lastname);
        setTicketsAmount(ticketsAmount);
    }

    public T getFlight() {
        return flight;
    }

    public void setFlight(T flight) {
        this.flight = flight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTicketsAmount() {
        return ticketsAmount;
    }

    public void setTicketsAmount(int ticketsAmount) {
        this.ticketsAmount = ticketsAmount;
    }
}
