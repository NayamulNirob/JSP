
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public static List<Employee> viewAllEmployee(){
    
    List<Employee> elist=new ArrayList<>();
    
    sql="select* from employee";
        try {
            ps=DbUtill.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {  
                
                Employee e =new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("address")
       
                );
                elist.add(e);
            }
            rs.close();
            ps.close();
            DbUtill.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDou.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elist;
    
    }
    
    public static void deleteEmployee(Employee e){
    
    sql="delete from employee where id=?";
    
        try {
            ps=DbUtill.getCon().prepareStatement(sql);
            ps.setInt(1, e.getId());
            
            ps.executeUpdate();
            
            ps.close();
            DbUtill.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDou.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
