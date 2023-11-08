package MainMenus.ManageBooking.FindBooking;

import BookingApp.Booking.Booking;
import BookingApp.Controller.BookingController;
import Flights.Flight.Flight;
import MainMenus.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SByNandLnBookings implements Command {
    BookingController controller = new BookingController();
    private static final Scanner in = new Scanner(System.in);
    @Override
    public void apply()  {

        controller.loadData();
        System.out.println("Your name?");
        String name = in.nextLine();
        System.out.println("Your lastname?");
        String lastname =in.nextLine();
        controller.search(name,lastname);



    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}