package MainMenus.ManageBooking;

import BookingApp.Controller.BookingController;
import MainMenus.Command;

import java.io.FileNotFoundException;

public class AllBookings implements Command {
    BookingController controller = new BookingController();
    @Override
    public void apply()  {
        
        controller.loadData();
        controller.getall();

    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
