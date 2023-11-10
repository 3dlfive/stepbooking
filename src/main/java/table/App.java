package table;

import MainMenus.*;
import MainMenus.ManageBooking.BookFlight;

public class App {
    private static App single_instance = null;

    public static synchronized App start() {
        if (single_instance == null) {
            single_instance = new App();
        }
        return single_instance;
    }

    public void run() {
        Menu menu = new Menu();
        menu.add("Згенерувати рейси", new GenerateFlights());
        menu.add("Онайн-табло останні 24 рейса", new ViewTable());
        menu.add("Знайти потрібний рейс", new FindFlight());
        menu.add("Подивитися інформацію про рейс", new ViewFlight());
        menu.add("Управління бронуванням", new BookFlight());
        menu.add("Мої рейси", new MyFlights());
        menu.add("Вихід", new Exit());

        while (true) {
            Command cmd = menu.listen();
            if (cmd.isExit()) {
                cmd.apply();
            } else {
                break;
            }
        }
    }
}
