package BookingApp.Passenger;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable {
    static final long serialVersionUID = 1;
    private String name;
    private String lastname;

    public Passenger(String name, String lastname) {
        setName(name);
        setLastname(lastname);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(getName(), passenger.getName()) && Objects.equals(getLastname(), passenger.getLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastname());
    }
}
