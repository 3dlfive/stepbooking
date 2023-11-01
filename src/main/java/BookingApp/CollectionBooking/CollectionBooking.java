package BookingApp.CollectionBooking;

import BookingApp.Booking.Booking;

import java.io.Serializable;
import java.util.ArrayList;

public class CollectionBooking implements Serializable {
    static final long serialVersionUID = 1;

    ArrayList<Booking> db = new ArrayList<>();
}
