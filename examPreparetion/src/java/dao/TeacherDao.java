
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Teacher;
import utill.Dbutill;

public class TeacherDao {
      static PreparedStatement ps;
    static ResultSet rs;
    static String sql;
    
    
    public static int saveTeacher(Teacher t){
    
    sql="insert into teacher(name,department,gender)"
            + "values(?,?,?)";
    int status=0;
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getDepartment());
            ps.setString(3, t.getGender());
           
  
            status=ps.executeUpdate();
            
            ps.close();
            Dbutill.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return status;
    }
    
    public static List<Teacher> viewAllTeacher(){
    
    List<Teacher> stlist=new ArrayList<>();
    
    sql="select* from teacher";
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {

                
                Teacher t=new Teacher(
                      
                      rs.getInt("id"), 
                      rs.getString("name"), 
                      rs.getString("department"), 
                      rs.getString("gender"));  
              stlist.add(t);
            }
         
            
            ps.close();
            Dbutill.getCon().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stlist;
    
    }
    public static void deleteTeacher(Teacher t){
    
    sql="delete from teacher where id=?";
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.executeUpdate();
            ps.close();
            Dbutill.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    public static void updateTeacher(Teacher t){
    
    sql="update teacher set name=?,department=?,gender=? where id=?";
    
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getDepartment());
            ps.setString(3, t.getGender());
            ps.setInt(4, t.getId());
            
            ps.executeUpdate();
            ps.close();
            Dbutill.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public static Teacher getById(int id){
    
    Teacher t = null;
    
    sql="select* from teacher where id=?";
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            
           rs= ps.executeQuery();
            
            while (rs.next()) {                
                   t = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("gender")     
                );
            }
            ps.close();
            Dbutill.getCon().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return t;
    }
}
