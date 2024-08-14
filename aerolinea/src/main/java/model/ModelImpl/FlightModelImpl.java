package model.ModelImpl;

import entity.FlightEntity;
import model.IModel.IFlightModel;
import persistence.ConnectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class FlightModelImpl implements IFlightModel {
    @Override
    public FlightEntity create(FlightEntity value) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO flight (destination, departure_date, departure_time, plane_id) values (?,?,?,?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, value.getDestination());
            ps.setDate(2, value.getDepartureDate());
            ps.setTime(3, value.getDepartureTime());
            ps.setInt(4, value.getPlaneId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                value.setId(rs.getInt(1));
                ps.close();
                return value;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al crear el vuelo: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return null;
    }

    @Override
    public void delete(FlightEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "DELETE FROM flight WHERE id = ?;";

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
            throw new RuntimeException("Error al eliminar el vuelo: "+e.getMessage());
        }
    }

    @Override
    public ArrayList<FlightEntity> read(FlightEntity value) throws ClassNotFoundException {
        ArrayList<FlightEntity> listFlight = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM flight WHERE id = ? or destination = ? or departure_date = ? or departure_time = ? or plane_id = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,value.getId());
            ps.setString(2,value.getDestination());
            ps.setDate(3,value.getDepartureDate());
            ps.setTime(4,value.getDepartureTime());
            ps.setInt(5,value.getPlaneId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FlightEntity flightRead = new FlightEntity();
                flightRead.setId(rs.getInt("id"));
                flightRead.setDestination(rs.getString("destination"));
                flightRead.setDepartureDate(rs.getDate("departure_date"));
                flightRead.setDepartureTime(rs.getTime("departure_time"));
                flightRead.setPlaneId(rs.getInt("plane_id"));
                listFlight.add(flightRead);
                ps.close();
                return listFlight;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al leer el vuelo: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return listFlight;
    }

    @Override
    public FlightEntity update(FlightEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE flight SET destination =?, departure_date =?, departure_time = ?, plane_id = ? WHERE id =?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getDestination());
            ps.setDate(2, entity.getDepartureDate());
            ps.setTime(3, entity.getDepartureTime());
            ps.setInt(4, entity.getPlaneId());
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
            throw new RuntimeException("Error al actualizar el avión: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public ArrayList<FlightEntity> readAll() throws ClassNotFoundException {
        ArrayList<FlightEntity> listFlight = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        String sql = "SELECT * FROM flight;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FlightEntity flightRead = new FlightEntity();
                flightRead.setId(rs.getInt("id"));
                flightRead.setDestination(rs.getString("destination"));
                flightRead.setDepartureDate(rs.getDate("departure_date"));
                flightRead.setDepartureTime(rs.getTime("departure_time"));
                flightRead.setPlaneId(rs.getInt("plane_id"));
                listFlight.add(flightRead);
            }
            ps.close();
            return listFlight;
        }catch(SQLException e){
            throw new RuntimeException("Error al leer todos los vuelos: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }
}
