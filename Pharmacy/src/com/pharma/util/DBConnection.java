
package com.pharma.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    public static Connection getConnection(){
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/inventory_management";
    String user = "root";
    String pass = "root";
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
}
