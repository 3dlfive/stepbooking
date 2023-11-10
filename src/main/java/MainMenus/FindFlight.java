package MainMenus;

import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.ControllerFlight.ControllerFlight;
import Flights.Enums.Airport;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;
import MainMenus.ManageBooking.*;
import MainMenus.ManageBooking.CancelBooking;
import MainMenus.ManageBooking.FindBooking.FindBookings;
import table.Menu;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class FindFlight implements Command{
    FlightDao dao = new CollectionFlightDAO(new ArrayList<>());
    ServiceFlight sf = new ServiceFlight(dao);
    ControllerFlight controllerFlight = new ControllerFlight(sf);
    private static final Scanner in = new Scanner(System.in);
    @Override
    public void apply() {
        try {
            controllerFlight.loadFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found it generate it");
            controllerFlight.generateFlights(500);
            controllerFlight.saveToFile();
        }
        System.out.println("Куди хочете полетіти?");
        String airport = in.nextLine();

        System.out.println("Введіть дату польоту у форматі dd/MM/yyyy:");
        String sdate;
        do{
            sdate = in.nextLine();
            if(!sdate.matches("^\\d{2}/\\d{2}/\\d{4}$")) System.out.print("треба ввести дату в форматі dd/MM/yyyy, спробуй ще раз:\n");
        }while (!sdate.matches("^\\d{2}/\\d{2}/\\d{4}$"));

        LocalDate date= LocalDate.of(
                Integer.parseInt(sdate.split("/")[2]),
                Integer.parseInt(sdate.split("/")[1]),
                Integer.parseInt(sdate.split("/")[0]));

        System.out.println("Скільки Вам потрібно місць?");
        int places = Integer.parseInt(in.nextLine());
        ArrayList<Flight> list = controllerFlight.getSpecific(Airport.valueOf(airport), date, places);
        if (list.isEmpty()){
            System.out.println("Вашим критеріям не підходить жодний з доступних рейсів");
        }
        else {
            System.out.println("Вашим критеріям підходять ці рейси:");
            list.forEach(System.out::println);
        }

        Menu menu = new Menu();
        menu.add("Забронювати рейс", new CreateBookingPlus(places));
        menu.add("До головного меню", new Exit());


        while (true) {
            Command cmd = menu.listen();
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
