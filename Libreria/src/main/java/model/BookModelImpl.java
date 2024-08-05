package model;

import entity.BookEntity;
import persistence.IModel.IBookModel;
import persistence.connectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookModelImpl implements IBookModel {
    @Override
    public BookEntity create(BookEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();

        String sql = "INSERT INTO book(title, age, price, author_id) VALUES (?,?,?,?);";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAge());
            ps.setFloat(3, entity.getPrice());
            ps.setInt(4, entity.getAuthor());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                entity.setId(rs.getInt("id"));
            }
            return entity;
        }catch(SQLException e){
            throw new RuntimeException("Error create: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }

    }

    @Override
    public void delete(BookEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        
        String sql = "DELETE FROM book WHERE id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
            int rowAffected = ps.executeUpdate();
            if(rowAffected > 0) {
                JOptionPane.showMessageDialog(null,"delete complete...");
            }else {
                JOptionPane.showMessageDialog(null,"delete fail...");
            }
        } catch(SQLException e){
            throw new RuntimeException("Error delete: "+e.getMessage());
        } finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public BookEntity update(BookEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE book SET title = ?,age = ?, price = ?, author_id = ? where id = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAge());
            ps.setFloat(3, entity.getPrice());
            ps.setInt(4, entity.getAuthor());
            ps.setInt(5, entity.getId());
            ps.executeUpdate();

            int rowAffected = ps.executeUpdate();
            if(rowAffected == 0) {
                JOptionPane.showMessageDialog(null,"update fail...");
                return null;
            }else {
                JOptionPane.showMessageDialog(null, "update complete...");
            }
            return entity;

        }catch(SQLException e){
            throw new RuntimeException("Error update: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public ArrayList<BookEntity> readAll() throws ClassNotFoundException {
        ArrayList<BookEntity> list = new ArrayList<BookEntity>();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM book ORDER BY id";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                BookEntity author = new BookEntity(rs.getInt("id"),rs.getString("title"),rs.getString("age"),rs.getFloat("price"),rs.getInt("author_id"));
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
    public BookEntity readById(BookEntity value) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();

        String sql = "SELECT * as author FROM book WHERE id =? OR title = ? OR age = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, value.getId());
            ps.setString(2, value.getTitle());
            ps.setString(3, value.getAge());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                BookEntity author = new BookEntity(rs.getInt("id"),rs.getString("title"),rs.getString("age"),rs.getFloat("price"),rs.getInt("author_id"));
                return author;
            }
            return null;
        }catch(SQLException e){
            throw new RuntimeException("Error of search: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }
}
