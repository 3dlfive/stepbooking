package MainMenus.ManageBooking;

import BookingApp.Booking.Booking;
import BookingApp.Controller.BookingController;
import Flights.CollectionFlightDAO.CollectionFlightDAO;
import Flights.ControllerFlight.ControllerFlight;
import Flights.Flight.Flight;
import Flights.ServiceFlight.ServiceFlight;
import MainMenus.Command;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateBooking implements Command {
    BookingController controller = new BookingController();
    private static final Scanner in = new Scanner(System.in);
    ControllerFlight flc = new ControllerFlight();
    @Override
    public void apply()  {
        try {flc.loadFromFile();} catch (FileNotFoundException e){
            System.out.println("File not found it generate it");
            flc.generateFlights(500);
            flc.saveToFile();
        }
        controller.loadData();
        System.out.println("Name?");
        String name = in.nextLine();
        System.out.println("lastname?");
        String lnmae = in.nextLine();
        System.out.println("Amount of tickets?");
        int aticket = in.nextInt();
        // Logic of chosen Flights
        System.out.println("FLight id?");
        int flightID = in.nextInt();
        Booking<Flight> book = new Booking<>(flc.getByID(flightID),name,lnmae,aticket);
        //Ask about passangers
        if (aticket>1){
            int i = 0;
            while((i<(aticket-1))){
                System.out.println(String.format("Name of passanger %s?",(i+1)));
                System.out.println("----");
//  Fist time ask bug? skip name
                String pn = in.nextLine();

                System.out.println(String.format("Lastname of passanger %s?",(i+1)));
                String pl = in.nextLine();
                book.addPasenger(pn,pl);
                i++;
            }
        }
        //we save to controller and to file
        controller.save(book);//При сейве не может сохранить флайт
    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
