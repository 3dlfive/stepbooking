package MainMenus;
import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;
import table.Console;


import Flights.ControllerFlight.ControllerFlight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ViewTable implements Command {
    FlightDao dao = new CollectionFlightDAO(new ArrayList<>());
    ServiceFlight sf = new ServiceFlight(dao);
    ControllerFlight controllerFlight = new ControllerFlight(sf);

    @Override
    public void apply() {
        File file = new File("Flights.txt");
        if (file.exists()) {
            // Файл існує, тому ми можемо спробувати його завантажити
            controllerFlight.loadFromFile();
        } else {
            // Файл не існує, ми повинні створити нову базу даних

            controllerFlight.generateFlights(100);

            List<Flight> nextFlights = controllerFlight.nextFlights();
            nextFlights.forEach(flight -> System.out.println(flight.toString()));

        }

    }
}

