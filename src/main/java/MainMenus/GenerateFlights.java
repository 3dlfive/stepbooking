package MainMenus;

import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.ControllerFlight.ControllerFlight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateFlights implements Command {
    FlightDao dao = new CollectionFlightDAO(new ArrayList<>());
    ServiceFlight sf = new ServiceFlight(dao);
    ControllerFlight controllerFlight = new ControllerFlight(sf);
    private static final Scanner in = new Scanner(System.in);
    @Override
    public void apply() {
        controllerFlight.clear();
        System.out.println("How many?");
        int amount = Integer.parseInt(in.nextLine());
        controllerFlight.generateFlights(amount);
        controllerFlight.saveToFile();
    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}