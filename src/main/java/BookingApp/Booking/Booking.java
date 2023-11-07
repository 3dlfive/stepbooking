package BookingApp.Booking;

import BookingApp.Controller.BookingController;
import BookingApp.Passenger.Passengers;
import Flights.Flight.Flight;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class Booking<T> implements Serializable {
    static final long serialVersionUID = 1;
    private transient T flight;
    private String name;

    public Booking(T flight,String name, String lastname, int ticketsAmount,Passengers passengers) {
        this(flight,name,lastname,ticketsAmount,LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),passengers);
    }

    public void setPl(Passengers pl) {
        this.pl = pl;
    }

    public Passengers getPl() {
        return pl;
    }

    private Passengers pl = new Passengers();

    private String lastname;
    private int ticketsAmount;
    private long bookingTime;
    private final String uniqueID = UUID.randomUUID().toString();
    public String getUniqueID() {
        return uniqueID;
    }



    public Booking(T flight, String name, String lastname, int ticketsAmount,String bookdate,Passengers passengers) {

        this.setFlight(flight);
        this.setName(name);
        this.setLastname(lastname);
        this.setTicketsAmount(ticketsAmount);
        this.setBookingTime(bookdate);
        this.setPl(passengers);
        this.pl.add(name,lastname);


    }
    public Booking(T flight, String name, String lastname, int ticketsAmount) {
        this(flight,name,lastname,ticketsAmount,LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),new Passengers(name,lastname));
    }
    public Booking(T flight, String name, String lastname) {
        this(flight,name,lastname,1,LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),new Passengers(name,lastname));
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking<?> booking = (Booking<?>) o;
        return Objects.equals(uniqueID, booking.uniqueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueID);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "flight=" + flight +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ticketsAmount=" + ticketsAmount +
                ", bookingTime=" + LocalDate.ofEpochDay(this.bookingTime).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", uniqueID='" + uniqueID + '\'' +
                ", " + this.getPl() + '\'' +
                '}';
    }
    public void setBookingTime(String year) {

        LocalDate time = LocalDate.parse(year, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        ;
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        long epoch = time.toEpochDay();
//      //20/03/2016
        this.bookingTime = epoch;
    }
    public Booking<T> addPasenger(String n, String ln){
        pl.add(n,ln);
        return this;
    }
    public Booking<T> removePasenger(String n, String ln){
        pl.drop(n,ln);
        return this;
    }

}
