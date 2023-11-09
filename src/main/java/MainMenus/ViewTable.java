package MainMenus;
import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;
import Flights.ServiceFlight.ServiceFlight;
import table.Console;


import Flights.ControllerFlight.ControllerFlight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ViewTable implements Command {
    FlightDao dao = new CollectionFlightDAO(new ArrayList<>());
    ServiceFlight sf = new ServiceFlight(dao);
    ControllerFlight controllerFlight = new ControllerFlight(sf);

    @Override
    public void apply() {
        try {controllerFlight.loadFromFile();} catch (FileNotFoundException e){
            System.out.println("File not found it generate it");
            controllerFlight.generateFlights(500);
            controllerFlight.saveToFile();
        }


        List<Flight> nextFlights = controllerFlight.nextFlights();
        nextFlights.forEach(flight -> System.out.println(flight.toString()));



    }

}
