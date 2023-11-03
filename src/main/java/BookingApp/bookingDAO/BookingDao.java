package BookingApp.bookingDAO;

import BookingApp.Booking.Booking;

import java.util.ArrayList;
import java.util.Optional;

public interface BookingDao {

ArrayList<Booking> getAllBookings();
    Optional<Booking> getByID(String uniqueID);
Boolean deleate(Booking booking);
Boolean smartAdd(Booking booking);
Boolean save(Booking booking);
ArrayList<Booking> loadData();
}
