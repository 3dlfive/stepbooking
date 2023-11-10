package BookingApp.CollectionBooking;

import BookingApp.Booking.Booking;
import BookingApp.bookingDAO.BookingDao;
import Flights.Flight.Flight;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CollectionBooking<T> implements Serializable, BookingDao {
    @Serial
    private static final long serialVersionUID = 1;
    private ArrayList<Booking<Flight>> db = new ArrayList<>();

    public void setDb(ArrayList<Booking<Flight> > db) {
        this.db = db;
    }



    public CollectionBooking(ArrayList<Booking<Flight> > db) {
        setDb(db);
    }


    @Override
    public ArrayList<Booking<Flight> >  getAllBookings() {
        return this.db;
    }

    @Override
    public Optional<Booking<Flight> > getByID(String uniqueID) {
        return this.db.stream().filter(el->el.getUniqueID().equals(uniqueID)).findFirst();
    }
    public List<Booking<Flight> > search(String lastnameOrName) {
        return this.db.stream().filter(el->el.getPl().ifInListAny(lastnameOrName)).toList();
    }
    public List<Booking<Flight> > search(String name,String lastname) {
        return this.db.stream().filter(el->el.getPl().ifInListNameandLname(name,lastname)).toList();
    }

    @Override
    public Boolean deleate(Booking<Flight>  booking) {

        return this.db.remove(booking);
    }
    public int countBookings(){
        return this.db.size();
    }
    @Override
    public Boolean deleateByUID(String uid) {
        List<Booking<Flight> > templist = this.db.stream().filter(el->!el.getUniqueID().equals(uid)).toList();
        ArrayList<Booking<Flight> > templ = new ArrayList<>(templist);
        System.out.println(templ);
        System.out.println(this.db.toString());
        setDb(templ);
        saveToFile(templ);
        return getByID(uid).isPresent();
    }

    @Override
    public Boolean smartAdd(Booking<Flight>  booking){
        if(db.contains(booking)){
            List<Booking<Flight>> templist = db.stream().map(el -> el.equals(booking) ? booking : el).toList();
            ArrayList<Booking<Flight>> templ = new ArrayList<>(templist);
            saveToFile(templ);
            return true;
        }else {

            boolean isadded = this.db.add(booking);
            saveToFile(db);
            return  isadded;
        }
    }


    public void saveToFile(ArrayList<Booking<Flight> > list){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("bookingDB.bin")
        )) {

            outputStream.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Booking<Flight> > loadData() {

        ArrayList<Booking<Flight> > bookingList = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("bookingDB.bin")
        )) {
            bookingList = (ArrayList<Booking<Flight> >) inputStream.readObject();

            System.out.println(bookingList);
        } catch (FileNotFoundException e) {
            this.saveToFile(bookingList);
            this.loadData();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (bookingList != null) {

            this.db.addAll(bookingList);
        }

        return bookingList;
    }
    public boolean addPassenger(String UID,String Name, String LastName) throws PassengersMoreThenTicketsException{
        Optional<Booking<Flight> > bookingThatWeLookingFor=  this.getByID(UID);

        if (bookingThatWeLookingFor.isPresent()){
            if (bookingThatWeLookingFor.get().getPl().getSize() > bookingThatWeLookingFor.get().getTicketsAmount()) throw new PassengersMoreThenTicketsException(String.format("Ви хочете додати пассажира але квитків тільки %S",bookingThatWeLookingFor.get().getTicketsAmount()),bookingThatWeLookingFor.get().getTicketsAmount());
            bookingThatWeLookingFor.get().addPasenger(Name,LastName);
           this.smartAdd(bookingThatWeLookingFor.get());
           return true;
        } else {
            return false;
        }
    }
    public boolean dropPassenger(String UID,String name, String lName) {
        Optional<Booking<Flight> > bookingThatWeLookingFor=  this.getByID(UID);
        if (bookingThatWeLookingFor.isPresent()){
           bookingThatWeLookingFor.get().removePasenger(name,lName);
           this.smartAdd(bookingThatWeLookingFor.get());
           return true;
        } else {
            return false;
        }
    }
}
