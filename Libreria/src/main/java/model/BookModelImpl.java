package model;

import entity.BookEntity;
import persistence.IModel.IBookModel;
import persistence.connectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class BookModelImpl implements IBookModel {
    @Override
    public BookEntity create(BookEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();

        String sql = "INSERT INTO book(title, age, price, author_id) VALUES (?,?,?,?);";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAge());
            ps.setFloat(3, entity.getPrice());
            ps.setInt(4, entity.getAuthor());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                entity.setId(rs.getInt(1));
            }
            ps.close();
            rs.close();
            return entity;
        }catch(SQLException e){
            throw new RuntimeException("Error create: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }

    }

    @Override
    public Boolean delete(BookEntity entity) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        
        String sql = "DELETE FROM book WHERE id =?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, entity.getId());
            ps.execute();

            return true;

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"delete fail...");
            return false;
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
                ps.close();
                return null;
            }else {
                JOptionPane.showMessageDialog(null, "update complete...");
                ps.close();
                return entity;
            }

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
            rs.close();
            ps.close();
            return list;
        }catch(SQLException e){
            throw new RuntimeException("Error of search: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public ArrayList<BookEntity> readById(BookEntity value) throws ClassNotFoundException {
        Connection connection = ConnectionDB.openConnection();
        ArrayList<BookEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE id = ? OR title = ? OR author_id = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, value.getId());
            ps.setString(2, value.getTitle());
            ps.setInt(3, value.getAuthor());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BookEntity search = new BookEntity();
                search.setId(rs.getInt("id"));
                search.setTitle(rs.getString("title"));
                search.setAge(rs.getString("age"));
                search.setPrice(rs.getFloat("price"));
                search.setAuthor(rs.getInt("author_id"));
                list.add(search);
            }

            ps.close();
            rs.close();
            return list;
        }catch(SQLException e){
            throw new RuntimeException("Error of search: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }

//    public static void main(String[] args) throws ClassNotFoundException {
//        BookModelImpl model = new BookModelImpl();
//        BookEntity book = new BookEntity("cien años de soledad","2010",30000,2);
//        BookEntity create = new BookEntity();
//        create = model.create(book);
//        JOptionPane.showMessageDialog(null, create);
//    }
}
