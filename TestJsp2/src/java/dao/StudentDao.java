
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import utill.DbUtill;




public class StudentDao {
    
//    static Student s=new Student();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;
    
    public static int saveStudent(Student s){
    int status=0;
    sql="insert into student(name,email,address,cell)"
            + "values(?,?,?,?)";
    
        try {
            ps=DbUtill.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getCell());
            
           status=ps.executeUpdate();
           
           ps.close();
           DbUtill.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    
    }
    
    public static List<Student> viewAllStudent(){
    
    List<Student> stlist=new ArrayList<>();
    
    sql="select* from student";
        try {
            ps=DbUtill.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {

                
              Student s=new Student(
                      
                      rs.getInt("id"), 
                      rs.getString("name"), 
                      rs.getString("email"), 
                      rs.getString("address"), 
                      rs.getString("cell")); 
              stlist.add(s);
            }
         
            
            ps.close();
            DbUtill.getCon().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stlist;
    
    }
}
