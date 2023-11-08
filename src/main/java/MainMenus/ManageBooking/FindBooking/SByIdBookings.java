package MainMenus.ManageBooking.FindBooking;

import BookingApp.Controller.BookingController;
import MainMenus.Command;

import java.util.Scanner;

public class SByIdBookings implements Command {
    BookingController controller = new BookingController();
    private static final Scanner in = new Scanner(System.in);
    @Override
    public void apply()  {

        controller.loadData();
        System.out.println("Enter UID");

        controller.findById(in.nextLine());
    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}