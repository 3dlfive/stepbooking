package BookingApp.CollectionBooking;

import BookingApp.Booking.Booking;
import BookingApp.bookingDAO.BookingDao;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CollectionBooking<T> implements Serializable, BookingDao {
    @Serial
    private static final long serialVersionUID = 1;
    private ArrayList<Booking> db = new ArrayList<>();

    public void setDb(ArrayList<Booking> db) {
        this.db = db;
    }



    public CollectionBooking(ArrayList<Booking> db) {
        setDb(db);
    }


    @Override
    public ArrayList<Booking>  getAllBookings() {
        return this.db;
    }

    @Override
    public Optional<Booking> getByID(String uniqueID) {
        return this.db.stream().filter(el->el.getUniqueID().equals(uniqueID)).findFirst();
    }
    public List<Booking> getByLastname(String lastname) {
        List<Booking> ll = this.db.stream().filter(el->el.getLastname().equals(lastname)).toList();
        return ll;
    }

    @Override
    public Boolean deleate(Booking booking) {

        return this.db.remove(booking);
    }
    public int countBookings(){
        return this.db.size();
    }
    @Override
    public Boolean deleateByUID(String uid) {
        List<Booking> templist = this.db.stream().filter(el->el.getUniqueID().equals(uid)).toList();
        ArrayList<Booking> templ = new ArrayList<>(templist);
        setDb(templ);
        saveToFile(templ);
        return getByID(uid).isPresent();
    }

    @Override
    public Boolean smartAdd(Booking booking){
        if(db.contains(booking)){
            List<Booking> templist = db.stream().map(el -> el.equals(booking) ? booking : el).toList();
            ArrayList<Booking> templ = new ArrayList<>(templist);
            saveToFile(templ);
            return true;
        }else {

            boolean isadded = this.db.add(booking);
            saveToFile(db);
            return  isadded;
        }
    }


    public void saveToFile(ArrayList<Booking> list){
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
    public ArrayList<Booking> loadData() {

        ArrayList<Booking> bookingList = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("bookingDB.bin")
        )) {
            bookingList = (ArrayList<Booking>) inputStream.readObject();

            System.out.println(bookingList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
}
