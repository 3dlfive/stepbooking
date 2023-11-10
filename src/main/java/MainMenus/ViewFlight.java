package MainMenus;


import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.ControllerFlight.ControllerFlight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewFlight implements Command {
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
        System.out.println("ID?");
        int id = Integer.parseInt(in.nextLine());
        System.out.println(controllerFlight.getByID(id).toString());
    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
