package BookingApp.Controller;

import BookingApp.Booking.Booking;
import BookingApp.CollectionBooking.CollectionBooking;
import BookingApp.Service.BookingService;
import CustomLogger.Logger;
import Flights.Flight.Flight;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingController implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    Logger logger = new Logger();
    BookingService controller = new BookingService();

    public BookingController(BookingService controller) {
        setController(controller);
    }

    public BookingController() {
        setController(new BookingService());
    }

    public void setController(BookingService controller) {
        this.controller = controller;
    }
    public ArrayList<Booking<Flight> > getall() {
        logger.info();
        return controller.getall();
    }

    public Optional<Booking<Flight>> findById(String id) {
        logger.info(id);
        System.out.println(controller.findById(id).toString());
        return controller.findById(id);
    }


    public boolean dropByClass(Booking<Flight>  booking) {
        logger.info(String.valueOf(booking));
        //delete by class
        return controller.dropByClass(booking);
    }

    public boolean dropByUID(String UID) {
        logger.info(UID);
        return controller.dropByUID(UID);
    }

    public int count() {
        logger.info();
        return controller.count();
    }

    public boolean save(Booking<Flight>  booking) {
        logger.info(booking.toString());
        return controller.save(booking);
    }

    public ArrayList<Booking<Flight> > loadData() {
        logger.info();
        return controller.loadData();
    }
    public ArrayList<Booking<Flight> > search(String nameorLname) {
        logger.info(nameorLname);
        System.out.println(controller.search(nameorLname).toString());
        return controller.search(nameorLname);
    }
    public List<Booking<Flight> > search(String name,String lastname) {
        logger.info(name+" "+lastname);
        System.out.println(controller.search(name,lastname).toString());
        return controller.search(name,lastname);
    }
    public boolean addPassanger(String UID,String name, String lName) {
        logger.info(UID+" "+name+" "+ lName);
        return controller.addPassenger(UID,name,lName);
    }
    public boolean dropPassenger(String UID,String name, String lName) {
        logger.info(UID+" "+name+" "+ lName);
        return controller.dropPassenger(UID,name,lName);
    }
}
