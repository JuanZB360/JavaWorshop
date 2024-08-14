package model.ModelImpl;

import entity.FlightEntity;
import entity.PassengerEntity;
import entity.ReservationEntity;
import model.IModel.IReservationModel;
import persistence.ConnectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ReservationModelImpl implements IReservationModel {
    @Override
    public ReservationEntity create(ReservationEntity value) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO reservation (passenger_id, flight_id, departure_date, seat) values (?,?,(SELECT departure_date FROM flight WHERE id = ?),?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, value.getPassengerId());
            ps.setInt(2, value.getFlightId());
            ps.setInt(3, value.getFlightId());
            ps.setString(4, value.getSeat());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                value.setId(rs.getInt(1));
                ps.close();
                return value;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al crear la reservacion: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return null;
    }

    @Override
    public void delete(ReservationEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "DELETE FROM reservation WHERE id = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,entity.getId());
            int rowAffected = ps.executeUpdate();
            if(rowAffected > 0) {
                ps.close();
                JOptionPane.showMessageDialog(null,"Reserva eliminada...");
            } else {
                ps.close();
                JOptionPane.showMessageDialog(null,"Reserva no Existe...");
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al eliminar la reservacion: "+e.getMessage());
        }
    }

    @Override
    public ArrayList<ReservationEntity> read(ReservationEntity value) throws ClassNotFoundException {
        ArrayList<ReservationEntity> listReservation = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM reservation WHERE id = ? or passenger_id = ? or flight_id = ? or departure_date = ? or seat = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,value.getId());
            ps.setInt(2,value.getPassengerId());
            ps.setInt(3,value.getFlightId());
            ps.setDate(4,value.getDepartureDate());
            ps.setString(5,value.getSeat());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ReservationEntity reservation = new ReservationEntity(rs.getInt("id"),rs.getInt("passenger_id"),rs.getInt("flight_id"), rs.getDate("departure_date"), rs.getString("seat"));
                listReservation.add(reservation);
            }
            ps.close();
            return listReservation;
        }catch(SQLException e){
            throw new RuntimeException("Error al leer la reservacion: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public ReservationEntity update(ReservationEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE reservation SET passenger_id = ?, flight_id = ?, departure_date = (SELECT departure_date FROM flight WHERE id = ?), seat = ? WHERE id = ?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, entity.getPassengerId());
            ps.setInt(2, entity.getFlightId());
            ps.setInt(3, entity.getFlightId());
            ps.setString(4, entity.getSeat());
            ps.setInt(5, entity.getId());

            int rowaffected  = ps.executeUpdate();
            if(rowaffected > 0) {
                ps.close();
                return entity;
            }else {
                ps.close();
                return null;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al actualizar la reservacion: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public ArrayList<ReservationEntity> readAll() throws ClassNotFoundException {
        ArrayList<ReservationEntity> listReservation = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        String sql = "SELECT * FROM reservation;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ReservationEntity reservationRead = new ReservationEntity();
                reservationRead.setId(rs.getInt("id"));
                reservationRead.setPassengerId(rs.getInt("passenger_id"));
                reservationRead.setFlightId(rs.getInt("flight_id"));
                reservationRead.setDepartureDate(rs.getDate("departure_date"));
                reservationRead.setSeat(rs.getString("seat"));
                listReservation.add(reservationRead);
            }
            ps.close();
            return listReservation;
        }catch(SQLException e){
            throw new RuntimeException("Error al leer todos las reservaciones: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public ReservationEntity readUnique(ReservationEntity value) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM reservation WHERE flight_id = ? and seat = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,value.getFlightId());
            ps.setString(2,value.getSeat());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ReservationEntity reservation = new ReservationEntity(rs.getInt("id"),rs.getInt("passenger_id"),rs.getInt("flight_id"), rs.getDate("departure_date"), rs.getString("seat"));
                ps.close();
                return reservation;
            }else{
                return null;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al leer la reservacion: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }
}
