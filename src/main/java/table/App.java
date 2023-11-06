package table;

import comands.*;

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
        menu.add("Онайн-табло", new ViewTable());
        menu.add("Подивитися інформацію про рейс", new ViewFlight());
        menu.add("Пошук та бронювання рейсу", new BookFlight());
        menu.add("Скасувати бронювання", new CancelBooking());
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
