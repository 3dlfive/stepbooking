package MainMenus.ManageBooking;


import MainMenus.Command;
import MainMenus.Exit;
import MainMenus.ManageBooking.AllBookings;
import MainMenus.ManageBooking.FindBooking.FindBookings;
import table.Menu;

public class BookFlight implements Command {
    @Override
    public void apply() {
        Menu menu2 = new Menu();
        menu2.add("Get all bookings", new AllBookings());
        menu2.add("Find Booking", new FindBookings());
        menu2.add("Create Booking", new CreateBooking());
        menu2.add("Cancel Booking", new CancelBooking());
        menu2.add("Back to main menu", new Exit());


        while (true) {
            Command cmd = menu2.listen();
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
