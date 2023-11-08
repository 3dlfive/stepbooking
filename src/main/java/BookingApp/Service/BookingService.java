package BookingApp.Service;

import BookingApp.Booking.Booking;
import BookingApp.CollectionBooking.CollectionBooking;
import Flights.Flight.Flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingService implements Serializable {
    private CollectionBooking<ArrayList<Booking<Flight> >> service = new CollectionBooking<>(new ArrayList<>());
    static final long serialVersionUID = 1;

    public BookingService(CollectionBooking<ArrayList<Booking<Flight> >> serviceArg) {
        setService(serviceArg);
    }

    public BookingService() {
        setService(new CollectionBooking<>(new ArrayList<Booking<Flight> >()));

    }

    public void setService(CollectionBooking<ArrayList<Booking<Flight> >> service) {
        this.service = service;
    }

    public ArrayList<Booking<Flight>> getall() {
        return service.getAllBookings();
    }

    public Optional<Booking<Flight>> findById(String id) {
        return service.getByID(id);
    }

    public ArrayList<Booking<Flight>> search(String ln) {
        return (ArrayList<Booking<Flight>>) service.search(ln);
    }
    public ArrayList<Booking<Flight>> search(String n,String ln) {
        return (ArrayList<Booking<Flight>>) service.search(n,ln);
    }

    public boolean dropByClass(Booking<Flight>  booking) {
        //delete by class
        return service.deleate(booking);
    }

    public boolean dropByUID(String UID) {
        return service.deleateByUID(UID);
    }

    public int count() {
        return service.countBookings();
    }

    public boolean save(Booking<Flight>  booking) {
        return service.smartAdd(booking);
    }

    public ArrayList<Booking<Flight> > loadData() {
        return service.loadData();
    }

    public boolean dropPassenger(String UID,String name, String lName){
        return service.dropPassenger(UID,name,lName);
    }    public boolean addPassenger(String UID,String name, String lName){
        return service.addPassenger(UID,name,lName);
    }


}
