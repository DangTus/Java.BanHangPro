package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    public static Connection getJDBCConection() {
        final String url = "jdbc:mysql://localhost:3306/java.banhangpro";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        Connection con = getJDBCConection();
        if(con==null) {
            System.out.println("sai");
        } else {
            System.out.println("dung");
        }
    }
}
