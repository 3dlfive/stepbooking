package MainMenus.ManageBooking;

import BookingApp.Controller.BookingController;
import MainMenus.Command;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CancelBooking implements Command {
    BookingController controller = new BookingController();
    private static final Scanner in = new Scanner(System.in);

    @Override
    public void apply() {
        controller.loadData();
        System.out.println("Выдалити по UID");
        System.out.println("Список усіх Бронювань:");
        controller.getall().stream().forEach(el -> System.out.println("\n"+el.getUniqueID() + " " + el.getLastname() + " " + el.getName()));
        controller.dropByUID(in.nextLine());

    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
