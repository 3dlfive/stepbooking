package MainMenus;
import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;
import table.Console;


import Flights.ControllerFlight.ControllerFlight;

import java.util.ArrayList;
import java.util.List;


public class ViewTable implements Command {
    FlightDao dao = new CollectionFlightDAO(new ArrayList<>());
    ServiceFlight sf = new ServiceFlight(dao);
    ControllerFlight controllerFlight = new ControllerFlight(sf);

    @Override
    public void apply() {
        controllerFlight.generateFlights(500);

        List<Flight> nextFlights = controllerFlight.nextFlights();
        nextFlights.forEach(flight -> System.out.println(flight.toString()));



    }

}
