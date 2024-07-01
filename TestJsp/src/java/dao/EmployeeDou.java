
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utill.DbUtill;

public class EmployeeDou {
//    static  Employee s =new Employee();
    static PreparedStatement ps;
    static ResultSet  rs;
    static String sql;
    
    public static int saveEmployee(Employee s){
        
    int status=0;
    
    sql="insert into employee (name,email,address)"
            + "values(?,?,?)";
    
        try {
            ps=DbUtill.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            
            
            status =ps.executeUpdate();
            System.out.println(status);
            
            ps.close();
            DbUtill.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDou.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    
    
    }
    
    
}
