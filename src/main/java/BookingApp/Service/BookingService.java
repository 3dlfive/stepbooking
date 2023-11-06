package BookingApp.Service;

import BookingApp.Booking.Booking;
import BookingApp.CollectionBooking.CollectionBooking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingService implements Serializable {
    private CollectionBooking<ArrayList<Booking>> service = new CollectionBooking<>(new ArrayList<>());
    static final long serialVersionUID = 1;

    public BookingService(CollectionBooking<ArrayList<Booking>> serviceArg) {
        setService(serviceArg);
    }

    public BookingService() {
        setService(new CollectionBooking<>(new ArrayList<Booking>()));
        ;
    }

    public void setService(CollectionBooking<ArrayList<Booking>> service) {
        this.service = service;
    }

    public ArrayList<Booking> getall() {
        return service.getAllBookings();
    }

    public Optional<Booking> findById(String id) {
        return service.getByID(id);
    }

    public List<Booking> findByLastName(String ln) {
        return service.getByLastname(ln);
    }

    public boolean dropByClass(Booking booking) {
        //delete by class
        return service.deleate(booking);
    }

    public boolean dropByUID(String UID) {
        return service.deleateByUID(UID);
    }

    public int count() {
        return service.countBookings();
    }

    public boolean save(Booking booking) {
        return service.smartAdd(booking);
    }

    public ArrayList<Booking> loadData() {
        return service.loadData();
    }




}
