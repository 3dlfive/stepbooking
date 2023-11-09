package MainMenus.ManageBooking;

import BookingApp.Booking.Booking;
import BookingApp.Controller.BookingController;
import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.ControllerFlight.ControllerFlight;
import Flights.Flight.Flight;
import Flights.ServiceFlight.ServiceFlight;
import MainMenus.Command;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateBooking implements Command {
    BookingController controller = new BookingController();
    private static final Scanner in = new Scanner(System.in);
    ControllerFlight fc = new ControllerFlight(new ServiceFlight(new CollectionFlightDAO(new ArrayList<>())));
    @Override
    public void apply()  {
        try {fc.loadFromFile();} catch (FileNotFoundException e){
            System.out.println("File not found it generate it");
            fc.generateFlights(500);
            fc.saveToFile();
        }
        controller.loadData();
        System.out.println("Выдалити по UID");
        System.out.println("Name?");
        String name = in.nextLine();
        System.out.println("lastname?");
        String lnmae = in.nextLine();
        System.out.println("Amount of tickets?");
        int aticket = in.nextInt();
        // Logic of chosen Flights
        Booking<Flight> book = new Booking<>(fc.getByID(1),name,lnmae,2);

        controller.save(book);
    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
