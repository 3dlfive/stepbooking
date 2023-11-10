package Flights.CollectionFlightDAO;

import Flights.Flight.Flight;
import Flights.FlightDAO.FlightDao;

import java.io.*;
import java.io.File;
import java.util.ArrayList;

public class CollectionFlightDAO implements FlightDao {
    private ArrayList<Flight> flights;

    public CollectionFlightDAO(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public ArrayList<Flight> getAll() {
        return flights;
    }

    @Override
    public Flight getByID(int id) {
        return flights.stream().filter(x -> x.getFlightID() == id).toList().get(0);
    }
    @Override
    public void add(Flight flight) {
        flights.add(flight);
    }

    @Override
    public void dataToFile() {
        File f = new File("Flights.txt");
        StringBuilder sb = new StringBuilder();
        for (Flight flight: flights){
            sb.append(flight.serialize());
            sb.append("\r\n");
        }

        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            f.delete();
            bw.write(sb.toString());
            bw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public void dataFromFile() throws FileNotFoundException {
        File f = new File("Flights.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            flights.clear();
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                flights.add(Flight.deserialize(line));
            }
        }catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void clear() {
        flights.clear();
    }
}
