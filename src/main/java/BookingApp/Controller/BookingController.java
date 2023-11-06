package BookingApp.Controller;

import BookingApp.Booking.Booking;
import BookingApp.CollectionBooking.CollectionBooking;
import BookingApp.Service.BookingService;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingController implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    BookingService controller = new BookingService();

    public BookingController(BookingService controller) {
        setController(controller);
    }

    public void setController(BookingService controller) {
        this.controller = controller;
    }
    public ArrayList<Booking> getall() {
        return controller.getall();
    }

    public Optional<Booking> findById(String id) {
        return controller.findById(id);
    }

    public List<Booking> findByLastName(String ln) {
        return controller.findByLastName(ln);
    }

    public boolean dropByClass(Booking booking) {
        //delete by class
        return controller.dropByClass(booking);
    }

    public boolean dropByUID(String UID) {
        return controller.dropByUID(UID);
    }

    public int count() {
        return controller.count();
    }

    public boolean save(Booking booking) {
        return controller.save(booking);
    }

    public ArrayList<Booking> loadData() {
        return controller.loadData();
    }
}
