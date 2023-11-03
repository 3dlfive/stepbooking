package BookingApp.Booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking case1;
    Booking case2;
    Booking case3;
    Booking case4;
    Booking case5;
    @BeforeEach

    void setup(){
        case1 = new Booking<>(new Object(),"Benita","Bradberry",5);
        case2 = new Booking<>(new Object(),"Vera","Hendricks",2);
        case3 = new Booking<>(new Object(),"Keturah","Persons",3);
        case4 = new Booking<>(new Object(),"Morrel","Brimmer",3);
        case5 = new Booking<>(new Object(),"Korri","Ofarrell",5);
    }
    @Test
    @DisplayName("Test that to object have diffrent UID")
    void getUniqueID() {

        assertNotEquals(case1.getUniqueID(),case2.getUniqueID());
    }



    @Test
    void getName() {
        assertEquals(case1.getName(),"Benita");
    }

    @Test
    void setName() {
        case1.setName("Diana");
        assertEquals(case1.getName(),"Diana");

    }

    @Test
    void getLastname() {
        assertEquals(case1.getLastname(),"Bradberry");

    }

    @Test
    void setLastname() {
        case2.setLastname("Ofarrell");
        assertEquals(case2.getLastname(),"Ofarrell");
    }

    @Test
    void getTicketsAmount() {
        assertEquals(case1.getTicketsAmount(),5);
    }

    @Test
    void setTicketsAmount() {
        case2.setTicketsAmount(1);
        assertEquals(case2.getTicketsAmount(),1);
    }

    @Test

    void testNotEquals() {
        assertFalse(case1.equals(case2));
    }

}