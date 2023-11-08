package BookingApp.CollectionBooking;

import CustomLogger.Logger;

public class PassengersMoreThenTicketsException extends RuntimeException {
    Logger looger = new Logger();
    private int size;
    public PassengersMoreThenTicketsException(String message, int size){
        super(message);
        looger.error(size);
        this.size = size;
    }

}
