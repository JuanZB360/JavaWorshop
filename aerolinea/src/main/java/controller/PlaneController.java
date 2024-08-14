package controller;

import entity.PlaneEntity;
import model.IModel.IPlaneModel;
import model.ModelImpl.PlaneModelImpl;

import java.util.ArrayList;

public class PlaneController {

    IPlaneModel plane = new PlaneModelImpl();

    public PlaneEntity CreatePlane(PlaneEntity value) throws ClassNotFoundException {
        return plane.create(value);
    }
    public void DeletePlane(PlaneEntity value) throws ClassNotFoundException {
        plane.delete(value);
    }
    public ArrayList<PlaneEntity> ReadPlane(PlaneEntity value) throws ClassNotFoundException {
        return plane.read(value);
    }
    public PlaneEntity UpdatePlane(PlaneEntity value) throws ClassNotFoundException {
        return plane.update(value);
    }
    public ArrayList<PlaneEntity> ReadAllPlanes() throws ClassNotFoundException {
        return plane.readAll();
    }
}
