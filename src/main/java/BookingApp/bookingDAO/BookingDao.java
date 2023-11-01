package BookingApp.bookingDAO;

import BookingApp.Booking.Booking;
import BookingApp.CollectionBooking.CollectionBooking;

import java.util.ArrayList;

public interface BookingDao {

CollectionBooking<Booking> getAllBookings();
Booking getByID(int index);
Boolean deleate(Booking booking);
Boolean save(Booking booking);
ArrayList<Booking> loadData();
}
