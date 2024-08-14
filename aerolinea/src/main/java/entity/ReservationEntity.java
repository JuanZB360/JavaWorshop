package entity;

import java.sql.Date;

public class ReservationEntity {
    //attribute
    private int id;
    private int passengerId;
    private int flightId;
    private Date departureDate;
    private String seat;

    //constructor
    public ReservationEntity(){}

    public ReservationEntity(int id){
        this.id = id;
    }

    public ReservationEntity(int passengerId, int flightId, String seat) {
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.seat = seat;
    }

    public ReservationEntity(int passengerId, int flightId, Date departureDate, String seat) {
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.departureDate = departureDate;
        this.seat = seat;
    }

    public ReservationEntity(int id, int passengerId, int flightId, Date departureDate, String seat) {
        this.id = id;
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.departureDate = departureDate;
        this.seat = seat;
    }

    //getters
    public int getId() {
        return id;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public String getSeat() {
        return seat;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    //method

    @Override
    public String toString() {
        return  "| Id: " + id +
                "| Pasajero: " + passengerId +
                "| Vuelo: " + flightId +
                "| Fecha: " + departureDate +
                "| Asiento: " + seat + " |\n";
    }
}
