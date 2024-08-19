/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import utill.Dbutill;

/**
 *
 * @author Admin
 */
public class StudentDao {
    
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;
   
    
    
    public static int saveStudent(Student s){
    
    sql="insert into student(name,email,address,cell)"
            + "values(?,?,?,?)";
    int status=0;
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getCell());
  
            status=ps.executeUpdate();
            
            ps.close();
            Dbutill.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return status;
    }
    
    public static List<Student> viewAllStudent(){
    
    List<Student> stlist=new ArrayList<>();
    
    sql="select* from student";
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
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
            Dbutill.getCon().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stlist;
    
    }
    public static void deleteStudent(Student s){
    
    sql="delete from student where id=?";
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.executeUpdate();
            ps.close();
            Dbutill.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    public static void updateStduent(Student s){
    
    sql="update student set name=?,email=?,address=?,cell=? where id=?";
    
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getCell());
            ps.setInt(5, s.getId());
            
            ps.executeUpdate();
            ps.close();
            Dbutill.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public static Student getById(int id){
    
    Student s = null;
    
    sql="select* from student where id=?";
        try {
            ps=Dbutill.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            
           rs= ps.executeQuery();
            
            while (rs.next()) {                
                   s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("cell")
                );
            }
            ps.close();
            Dbutill.getCon().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return s;
    }
}
