package BookingApp.Passenger;

import CustomLogger.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class Passengers implements Serializable {
    Logger log = new Logger();
    static final long serialVersionUID = 1;
    ArrayList<Passenger> passengerslist = new ArrayList<>();

    public Passengers(ArrayList<Passenger> passengerslist) {
       this.setPassengerslist(passengerslist);
    }
    public Passengers() {
        setPassengerslist(new ArrayList<Passenger>());
    }
    public Passengers(String name, String lname) {
       ArrayList<Passenger> tl = new ArrayList<Passenger>();
       tl.add(new Passenger(name,lname));
        setPassengerslist(tl);
    }

    public ArrayList<Passenger> getPassengerslist() {
        return passengerslist;
    }

    public void setPassengerslist(ArrayList<Passenger> passengerslist) {
        this.passengerslist = passengerslist;
    }
    public Passengers add(String name,String lastname) {

        Passenger tp = new Passenger(name,lastname);
        Optional<Passenger> list = passengerslist.stream().filter(el->el.equals(tp)).findFirst();
        if (list.isEmpty()){

            log.info(name + lastname+" True.");
            passengerslist.add(tp);
            return  this;
        } else {
            log.info(name + lastname + "False");
            return  this;
        }


    }
    public Passengers drop(String name,String lastname) {
        Passenger tp = new Passenger(name,lastname);
        Optional<Passenger> list = passengerslist.stream().filter(el->el.equals(tp)).findFirst();
        if (list.isEmpty()){
            passengerslist.remove(tp);
            log.info(name + lastname + " false to drop");
            return  this;
        } else {
            log.info(name + lastname + " true to drop");
            return this;
        }


    }
    public  int getSize(){
        return passengerslist.size();
    }
    public  boolean ifInListAny(String nameOrLastname){
        Predicate<Passenger> startPredicate = el -> (el.getLastname().equals(nameOrLastname)||el.getName().equals(nameOrLastname));
        return passengerslist.stream().anyMatch(startPredicate);
    }
    public  boolean ifInListNameandLname(String name,String Lastname){
        Predicate<Passenger> startPredicate = el -> (el.getLastname().equals(Lastname)&&el.getName().equals(name));
        return passengerslist.stream().anyMatch(startPredicate);
    }


    @Override
    public String toString() {
        return "Passengers{" +
                "passengerslist=" + passengerslist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passengers that = (Passengers) o;
        return Objects.equals(getPassengerslist(), that.getPassengerslist());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassengerslist());
    }
}
