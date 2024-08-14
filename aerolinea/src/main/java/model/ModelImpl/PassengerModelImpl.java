package model.ModelImpl;


import entity.FlightEntity;
import entity.PassengerEntity;
import model.IModel.IPassengerModel;
import persistence.ConnectionDataBase.ConnectionDB;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PassengerModelImpl implements IPassengerModel {
    @Override
    public PassengerEntity create(PassengerEntity value) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO passenger (name, last_name, document_id) values (?,?,?);";

        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, value.getName());
            ps.setString(2, value.getLastName());
            ps.setString(3, value.getDocumentId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                value.setId(rs.getInt(1));
                ps.close();
                return value;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al crear el pasajero: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return null;
    }

    @Override
    public void delete(PassengerEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "DELETE FROM passenger WHERE id = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,entity.getId());
            int rowAffected = ps.executeUpdate();
            if(rowAffected > 0) {
                ps.close();
                JOptionPane.showMessageDialog(null,"Pasajero eliminado...");
            } else {
                ps.close();
                JOptionPane.showMessageDialog(null,"Pasajero no Existe...");
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al eliminar el pasajero: "+e.getMessage());
        }
    }

    @Override
    public ArrayList<PassengerEntity> read(PassengerEntity value) throws ClassNotFoundException {
        ArrayList<PassengerEntity> listPassenger = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM passenger WHERE id =? or name = ? or last_name = ? or document_id = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,value.getId());
            ps.setString(2,value.getName());
            ps.setString(3,value.getLastName());
            ps.setString(4,value.getDocumentId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PassengerEntity passenger = new PassengerEntity(rs.getInt("id"),rs.getString("name"),rs.getString("last_name"), rs.getString("document_id"));
                listPassenger.add(passenger);
            }
            ps.close();
            return listPassenger;
        }catch(SQLException e){
            throw new RuntimeException("Error al leer el vuelo: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public PassengerEntity update(PassengerEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE passenger SET name =?, last_name =?, document_id = ? WHERE id =?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getDocumentId());
            ps.setInt(4, entity.getId());
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
    public ArrayList<PassengerEntity> readAll() throws ClassNotFoundException {
        ArrayList<PassengerEntity> listPassenger = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        String sql = "SELECT * FROM passenger;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PassengerEntity passengerRead = new PassengerEntity();
                passengerRead.setId(rs.getInt("id"));
                passengerRead.setName(rs.getString("name"));
                passengerRead.setLastName(rs.getString("last_name"));
                passengerRead.setDocumentId(rs.getString("document_id"));
                listPassenger.add(passengerRead);
            }
            ps.close();
            return listPassenger;
        }catch(SQLException e){
            throw new RuntimeException("Error al leer todos los Pasajeros: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }
}
