
package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dbutill {
    static Connection con=null;
    static String url="jdbc:mysql://localhost:3306/dbcrued";
    static String user="root";
    static String password="2020";
    static String driver="com.mysql.cj.jdbc.Driver";
    
    
    public static Connection getCon(){
    
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Dbutill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    
    }
}
