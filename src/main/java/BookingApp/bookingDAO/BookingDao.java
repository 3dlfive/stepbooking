package BookingApp.bookingDAO;

import BookingApp.Booking.Booking;
import Flights.Flight.Flight;

import java.util.ArrayList;
import java.util.Optional;

public interface BookingDao {

ArrayList<Booking<Flight>> getAllBookings();
Optional<Booking<Flight>> getByID(String uniqueID);
Boolean deleate(Booking<Flight> booking);
Boolean deleateByUID(String uid);

Boolean smartAdd(Booking<Flight> booking);
ArrayList<Booking<Flight>> loadData();
}
