package controller;

import entity.PassengerEntity;
import model.IModel.IPassengerModel;
import model.ModelImpl.PassengerModelImpl;

import java.util.ArrayList;

public class PassengerController {

    IPassengerModel passenger = new PassengerModelImpl();

    public PassengerEntity CreatePassenger(PassengerEntity value) throws ClassNotFoundException {
        return passenger.create(value);
    }
    public void DeletePassenger(PassengerEntity value) throws ClassNotFoundException {
        passenger.delete(value);
    }
    public ArrayList<PassengerEntity> ReadPassenger(PassengerEntity value) throws ClassNotFoundException {
        return passenger.read(value);
    }
    public PassengerEntity UpdatePassenger(PassengerEntity value) throws ClassNotFoundException {
        return passenger.update(value);
    }
    public ArrayList<PassengerEntity> ReadAllPassenger() throws ClassNotFoundException {
        return passenger.readAll();
    }
}
