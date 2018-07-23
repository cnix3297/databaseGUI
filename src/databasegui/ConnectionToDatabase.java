package databasegui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.JDBC;
/**
 *
 * @author charles
 */
public class ConnectionToDatabase {
    Connection connection = null;
    
    public static Connection ConnectDB(){
    try{
    Class.forName("org.sqlite.JDBC");
    Connection conn = (Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\charles\\Documents\\NetBeansProjects\\assign-11-2\\databaseGUI\\testgui.db");
    return conn;
    }   catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectionToDatabase.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
    
    
    }
}
