package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modle.Student;
import utill.DbUtill;

public class StudentDao {

	static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";

    public static int saveStudent(Student s) {

        int status = 0;

        sql = "insert into student(name, email, address, cell) "
                + "values(?,?,?,?)";

        try {
            ps = DbUtill.getCon().prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getCell());

            status = ps.executeUpdate();
            System.out.println(status);

            ps.close();
            DbUtill.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public static List<Student> viewAllStudent() {
        List<Student> stList = new ArrayList<>();

        sql = "select * from student";

        try {
            ps = DbUtill.getCon().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("cell")
                );

                stList.add(s);
            }

            rs.close();
            ps.close();
            DbUtill.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stList;
    }

    public static void deleteStudent(Student s) {
        sql = "delete from student where id=?";

        try {
            ps = DbUtill.getCon().prepareStatement(sql);

            ps.setInt(1, s.getId());

            ps.executeUpdate();

            ps.close();
            DbUtill.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateStudent(Student s) {

        sql = "update student set name=?, email=?, address=?, cell=? where id=?";

        try {
            ps = DbUtill.getCon().prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getCell());
            ps.setInt(5, s.getId());

            ps.executeUpdate();

            ps.close();
            DbUtill.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Student getById(int id) {

        Student s = null;

        sql = "select * from student where id=?";

        try {
            ps = DbUtill.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {

                s = new modle.Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("cell")
                );

            }

            ps.close();
            DbUtill.getCon().close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
	
	
}