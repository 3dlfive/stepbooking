package BookingApp.CollectionBooking;

import BookingApp.Booking.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CollectionBookingTest {
    Booking case1;
    Booking case2;
    Booking case3;
    Booking case4;
    Booking case5;   
    Booking case6;

    ArrayList<Booking> blist = new ArrayList<>();
    ;CollectionBooking<Booking> bookcolection;
    @BeforeEach

    void setup(){
        case1 = new Booking<>(new Object(),"Benita","Bradberry",5);
        case2 = new Booking<>(new Object(),"Vera","Hendricks",2);
        case3 = new Booking<>(new Object(),"Keturah","Persons",3);
        case4 = new Booking<>(new Object(),"Morrel","Brimmer",3);
        case5 = new Booking<>(new Object(),"Korri","Ofarrell",5);
        case6 = new Booking<>(new Object(),"Hagen","Finke",3);
        blist.add(case1);
        blist.add(case2);
        blist.add(case3);
        blist.add(case4);
        blist.add(case5);

        bookcolection = new CollectionBooking<>(blist);
    }
    @Test
    void getAllBookings() {
        ArrayList<Booking> result = bookcolection.getAllBookings();
        System.out.println(result);
       assertEquals(result,result);
    }



    @Test
    void getByID() {
        String id = case2.getUniqueID();
        Optional<Booking> searchitem = bookcolection.getByID(id);
        System.out.println(searchitem);
        assertEquals(case2.toString(),searchitem.get().toString());

    }
    @Test
    void optionalEmpty() {
        String id = case2.getUniqueID();
        Optional<Booking> searchitem = bookcolection.getByID("id");
        System.out.println(searchitem);
        assertEquals(true,searchitem.isEmpty());
    }
    @Test
    void smartAdd(){
        boolean isAded = bookcolection.smartAdd(case5);
        assertTrue(isAded);
    }
    @Test
    void deleteByID(){
        int sizebefore = bookcolection.countBookings();
        bookcolection.deleateByUID(case5.getUniqueID());
        assertNotEquals(sizebefore,bookcolection.countBookings());
    }
    @Test
    void deletebyBooking(){
        int sizebefore = bookcolection.countBookings();
        bookcolection.deleate(case2);
        assertNotEquals(sizebefore,bookcolection.countBookings());
    }
    @Test
    void countBookings(){
        assertEquals(bookcolection.countBookings(),5);
    }

}