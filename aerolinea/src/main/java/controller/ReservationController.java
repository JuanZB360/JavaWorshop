package controller;


import entity.PlaneEntity;
import entity.ReservationEntity;
import model.IModel.IReservationModel;
import model.ModelImpl.ReservationModelImpl;

import java.util.ArrayList;

public class ReservationController {
    IReservationModel reservation = new ReservationModelImpl();

    public ReservationEntity CreateReservation(ReservationEntity value) throws ClassNotFoundException {
        return reservation.create(value);
    }
    public void DeleteReservation(ReservationEntity value) throws ClassNotFoundException {
        reservation.delete(value);
    }
    public ArrayList<ReservationEntity> ReadReservation(ReservationEntity value) throws ClassNotFoundException {
        return reservation.read(value);
    }
    public ReservationEntity UpdateReservation(ReservationEntity value) throws ClassNotFoundException {
        return reservation.update(value);
    }
    public ArrayList<ReservationEntity> ReadAllReservations() throws ClassNotFoundException {
        return reservation.readAll();
    }
    public ReservationEntity ReadUnique (ReservationEntity value) throws ClassNotFoundException {
        return reservation.readUnique(value);
    }
}
