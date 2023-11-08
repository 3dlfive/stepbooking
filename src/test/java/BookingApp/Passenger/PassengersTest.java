package BookingApp.Passenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PassengersTest {
    Passenger passenger1 = new Passenger("John", "Doe");
    Passenger passenger2 = new Passenger("Jessica", "Marraci");
    Passenger passenger3 = new Passenger("Brune", "Smith");
    Passengers passangers;


    @BeforeEach

    void setup() {
        ArrayList<Passenger> pl = new ArrayList<>();
        pl.add(passenger1);
        pl.add(passenger2);
        pl.add(passenger3);
        passangers = new Passengers(pl);

    }
    @ParameterizedTest(name="{0} = {1}")
    @DisplayName("Check inlist method.")
    @CsvSource({
            "Brune,true",
            "John,true",
            "Jessica,true",
            "Doe,true",
            "Marraci,true",
            "Oleg,false",
            "Nicki,false",
            "Tonny,false",
            "Smith,true"
    })
    void ifInList(String  nameOrLastname,boolean expectedResult) {

        assertEquals(passangers.ifInListAny(nameOrLastname),expectedResult);
    }
    @ParameterizedTest(name="{0} = {1} = {2}")
    @DisplayName("Check inlist method.")
    @CsvSource({
            "John,Doe,true",
            "Jessica,Marraci,true",
            "Brune,Smith,true",
            "Brune,Marraci,false",
            "Doe,John,false",
            "Smith,John,false",

    })
    void ifInListNameandLname(String  name, String lname,boolean expectedResult) {

        assertEquals(passangers.ifInListNameandLname(name,lname),expectedResult);
    }

}