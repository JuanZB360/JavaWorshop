package controller;

import Util.Verification;
import entity.FlightEntity;
import model.IModel.IFlightModel;
import model.ModelImpl.FlightModelImpl;

import java.util.ArrayList;

public class FlightController {

    IFlightModel flight = new FlightModelImpl();

    public FlightEntity CreateFlight(FlightEntity value) throws ClassNotFoundException {
        return flight.create(value);
    }
    public void DeleteFlight(FlightEntity value) throws ClassNotFoundException {
        flight.delete(value);
    }
    public ArrayList<FlightEntity> ReadFlight(FlightEntity value) throws ClassNotFoundException {
        return flight.read(value);
    }
    public FlightEntity UpdateFlight(FlightEntity value) throws ClassNotFoundException {
        return flight.update(value);
    }
    public ArrayList<FlightEntity> ReadAllFlight() throws ClassNotFoundException {
        return flight.readAll();
    }
}
