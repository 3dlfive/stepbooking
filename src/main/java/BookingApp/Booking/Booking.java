package BookingApp.Booking;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Booking<T> implements Serializable {
    static final long serialVersionUID = 1;
    private transient T flight;
    private String name;
    private String lastname;
    private int ticketsAmount;
    private long bookingTime;
    private final String uniqueID = UUID.randomUUID().toString();
    public String getUniqueID() {
        return uniqueID;
    }



    public Booking(T flight, String name, String lastname, int ticketsAmount,String bookdate) {

        this.setFlight(flight);
        this.setName(name);
        this.setLastname(lastname);
        this.setTicketsAmount(ticketsAmount);
        this.setBookingTime(bookdate);


    }
    public Booking(T flight, String name, String lastname, int ticketsAmount) {
        this(flight,name,lastname,ticketsAmount,LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
    public Booking(T flight, String name, String lastname) {
        this(flight,name,lastname,1,LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
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
                ", uniqueID='" + uniqueID + '\'' +
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
}
