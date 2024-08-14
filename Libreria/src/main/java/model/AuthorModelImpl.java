package model;

import entity.AuthorEntity;
import persistence.IModel.IAuthorModel;
import persistence.connectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class AuthorModelImpl implements IAuthorModel {

    @Override
    public AuthorEntity create(AuthorEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();

        String sql = "INSERT INTO author (name,nationality) VALUES (?, ?)";

        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getNationality());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){

                entity.setId(rs.getInt(1));
            }

            return entity;

        }catch(SQLException e){
            throw new RuntimeException("Error creating" + e);
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public AuthorEntity delete(AuthorEntity request) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();

        String sql = "DELETE FROM author WHERE id =?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, request.getId());

            ps.execute();

            JOptionPane.showMessageDialog(null,"Delete Complete...");
            return request;

        }catch(SQLException e){
            throw new RuntimeException("Error deleting: " + e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public AuthorEntity readById(AuthorEntity request) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();

        String sql = "SELECT * FROM author WHERE id =?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, request.getId());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                request.setName(rs.getString("name"));
                request.setNationality(rs.getString("nationality"));
            }
            return request;

        }catch(SQLException e){
            throw new RuntimeException("Error reading: " + e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public ArrayList<AuthorEntity> readAll() throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        ArrayList<AuthorEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM author ORDER BY id";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                AuthorEntity author = new AuthorEntity(rs.getInt("id"),rs.getString("name"),rs.getString("nationality"));
                list.add(author);
            }
            return list;
        }catch(SQLException e){
            throw new RuntimeException("Error of search: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public AuthorEntity update(AuthorEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        
        String sql = "UPDATE author SET name =?, nationality =? WHERE id =?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getNationality());
            ps.setInt(3, entity.getId());
            
            ps.execute();

            return entity;

        }catch(SQLException e){
            throw new RuntimeException("Error Update: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }
    }

//    public static void main(String[] args) throws ClassNotFoundException {
//        AuthorEntity entity = new AuthorEntity("juan","colombia");
//        AuthorModelImpl model = new AuthorModelImpl();
//        AuthorEntity entity2= new AuthorEntity();
////        entity2 = model.readById(entity);
////        JOptionPane.showMessageDialog(null,entity2);
//        entity2 = model.create(entity);
//        JOptionPane.showMessageDialog(null,entity2);
//
//    }
}
