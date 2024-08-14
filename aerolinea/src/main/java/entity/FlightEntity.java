package entity;

import java.sql.Date;
import java.sql.Time;

public class FlightEntity {
    //attribute
    private int id;
    private String destination;
    private Date departureDate;
    private Time departureTime;
    private int planeId;

    //constructor
    public FlightEntity(){}

    public FlightEntity(int id){
        this.id = id;
    }

    public FlightEntity(String destination, Date departureDate, Time departureTime, int planeId) {
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.planeId = planeId;
    }

    public FlightEntity(int id, String destination, Date departureDate, Time departureTime, int planeId) {
        this.id = id;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.planeId = planeId;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public int getPlaneId() {
        return planeId;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    //method


    @Override
    public String toString() {
        return  "| id:" + id +
                "| Destino: " + destination +
                "| Fecha: " + departureDate +
                "| hora: " + departureTime +
                "| avion: " + planeId + " |\n ";
    }
}
