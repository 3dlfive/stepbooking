package BookingApp.CollectionBooking;

import BookingApp.Booking.Booking;
import BookingApp.Passenger.Passenger;
import BookingApp.Passenger.Passengers;
import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.ControllerFlight.ControllerFlight;
import Flights.Flight.Flight;
import Flights.ServiceFlight.ServiceFlight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CollectionBookingTest {
    Booking<Flight>  case1;
    Booking<Flight>  case2;
    Booking<Flight>  case3;
    Booking<Flight>  case4;
    Booking<Flight>  case5;
    Booking<Flight>  case6;
    Booking<Flight>  case7;
    ArrayList<Booking<Flight> > blist = new ArrayList<>();
    CollectionBooking<Booking<Flight> > bookcolection;
    Passenger p1 = new Passenger("Lamesha", "Maurin");
    Passenger p2 = new Passenger("Pento", "Dino");
    Passenger p3 = new Passenger("Esha", "Maur");
    Passenger p4 = new Passenger("Lame", "Rin");
    ArrayList<Passenger> plist = new ArrayList<>();
    Passengers pl = new Passengers();
    @BeforeEach

    void setup(){
        ControllerFlight fc = new ControllerFlight(new ServiceFlight(new CollectionFlightDAO(new ArrayList<>())));
        fc.generateFlights(15);
        case1 = new Booking<>(fc.getByID(0),"Benita","Bradberry",5);
        case2 = new Booking<>(fc.getByID(1),"Vera","Hendricks",2);
        case3 = new Booking<>(fc.getByID(2),"Keturah","Persons",3);
        case4 = new Booking<>(fc.getByID(3),"Vera","Brimmer",3);
        case5 = new Booking<>(fc.getByID(4),"Korri","Ofarrell",5);
        case6 = new Booking<>(fc.getByID(5),"Hagen","Finke",2);

        pl.setPassengerslist(plist);
        case7 = new Booking<>(fc.getByID(6),"QESA","Finke",2,pl);
        blist.add(case1);
        blist.add(case2);
        blist.add(case3);
        blist.add(case4);
        blist.add(case5);

        bookcolection = new CollectionBooking<>(blist);
    }
    @Test
    void getAllBookings() {
        ArrayList<Booking<Flight>> result = bookcolection.getAllBookings();
        System.out.println(result);
       assertEquals(result,result);
    }



    @Test
    void getByID() {
        String id = case2.getUniqueID();
        Optional<Booking<Flight>> searchitem = bookcolection.getByID(id);
        System.out.println(searchitem);
        assertEquals(case2.toString(),searchitem.get().toString());

    }
    @Test
    void optionalEmpty() {
        String id = case2.getUniqueID();
        Optional<Booking<Flight>> searchitem = bookcolection.getByID("id");
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
    @Test
    @DisplayName("Not found search by name or lastname")
    void byNameorLastname(){
assertEquals(bookcolection.search("aas").size(),0);
    }
    @Test
    @DisplayName("Found search by name and lastname")
    void byNameorLastname2(){
assertEquals(bookcolection.search("Benita","Bradberry").size(),1);
    }
    @Test
    @DisplayName("Found search by name or lastname ")
    void byNameorLastname3(){
assertEquals(bookcolection.search("Vera").size(),2);
    }
    @Test
    void testExceptionWhenAddmorepassenger() {
        String uid = case2.getUniqueID();

        assertThrows(PassengersMoreThenTicketsException.class, () -> {
            bookcolection.addPassenger(uid,"Finish","Den");
            bookcolection.addPassenger(uid,"Fsc","Chrome");
            bookcolection.addPassenger(uid,"Fsca","XChrome");
        });

    }
}