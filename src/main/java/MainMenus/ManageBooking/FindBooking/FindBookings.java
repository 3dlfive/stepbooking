package MainMenus.ManageBooking.FindBooking;

import BookingApp.Controller.BookingController;
import MainMenus.Command;
import MainMenus.Exit;
import table.Menu;

public class FindBookings implements Command {


    @Override
    public void apply() {
        Menu menu3 = new Menu();
        menu3.add("Search by id.", new SByIdBookings());
        menu3.add("Search by Name Lastname ", new SByNandLnBookings());
        menu3.add("Back", new Exit());



        while (true) {
            Command cmd = menu3.listen();
            if (cmd.isExit()) {
                cmd.apply();
            } else {
                break;
            }
        }
    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}