package model.ModelImpl;

import entity.FlightEntity;
import entity.PlaneEntity;
import model.IModel.IPlaneModel;
import persistence.ConnectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PlaneModelImpl implements IPlaneModel {
    @Override
    public PlaneEntity create(PlaneEntity value) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO plane (model,capacity) values (?,?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, value.getModel());
            ps.setInt(2, value.getCapacity());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                value.setId(rs.getInt(1));
                ps.close();
                return value;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al crear el avión: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return null;
    }

    @Override
    public void delete(PlaneEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "DELETE FROM plane WHERE id = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,entity.getId());
            int rowAffected = ps.executeUpdate();
            if(rowAffected > 0) {
                ps.close();
                JOptionPane.showMessageDialog(null,"Avion eliminado...");
            } else {
                ps.close();
                JOptionPane.showMessageDialog(null,"Avion no Existe...");
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al eliminar el avión: "+e.getMessage());
        }
    }

    @Override
    public ArrayList<PlaneEntity> read(PlaneEntity value) throws ClassNotFoundException {
        ArrayList<PlaneEntity> listPlane = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM plane WHERE id =? or model = ? or capacity = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,value.getId());
            ps.setString(2,value.getModel());
            ps.setInt(3,value.getCapacity());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                PlaneEntity plane = new PlaneEntity(rs.getInt("id"),rs.getString("model"),rs.getInt("capacity"));
                listPlane.add(plane);
                ps.close();
                return listPlane;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al leer el avión: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return listPlane;
    }

    @Override
    public PlaneEntity update(PlaneEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE plane SET model =?, capacity =? WHERE id =?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getModel());
            ps.setInt(2, entity.getCapacity());
            ps.setInt(3, entity.getId());
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
    public ArrayList<PlaneEntity> readAll() throws ClassNotFoundException {
        ArrayList<PlaneEntity> listPlane = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        String sql = "SELECT * FROM plane;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PlaneEntity planeRead = new PlaneEntity();
                planeRead.setId(rs.getInt("id"));
                planeRead.setModel(rs.getString("model"));
                planeRead.setCapacity(rs.getInt("capacity"));
                listPlane.add(planeRead);
            }
            ps.close();
            return listPlane;
        }catch(SQLException e){
            throw new RuntimeException("Error al leer todos los Aviones: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }
}
