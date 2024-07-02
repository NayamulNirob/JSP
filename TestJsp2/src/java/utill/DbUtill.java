
package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtill {
    
    private static Connection con =null;
    private static String url="jdbc:mysql://localhost:3306/dbcrud";
    private static String user="root";
    private static String password="2020";
    private static String driver="com.mysql.cj.jdbc.Driver";
    
    public static Connection getCon(){
    
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbUtill.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return con;
    }
}
