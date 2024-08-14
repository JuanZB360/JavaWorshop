package persistence.ConnectionDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection connection = null;

    public static Connection openConnection() throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/aerolinea";
        String user = "root";
        String password = "juan123";

        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Open Connection...");
        }catch(SQLException e){
            throw new RuntimeException("Error connecting to the database: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
                System.out.println("Closed Connection...");
            }catch(SQLException e){
                throw new RuntimeException("Error closing the database connection: " + e.getMessage());
            }
        }
    }

//    public static void main(String[] args) throws ClassNotFoundException {
//        ConnectionDB.openConnection();
//        ConnectionDB.closeConnection();
//    }
}
