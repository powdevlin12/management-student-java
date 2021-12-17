/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Dat
 */
public class StudentDAO {

    private List<Student> arr = new ArrayList();

    public static Connection getConnect() {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-9I603FR\\SQLEXPRESS;databaseName=QLYSACH;user=sa;password=123");
            System.out.println("ket noi thanh cong !");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ket noi that bai !");
        }
        return null;
    }

    public int addStudent(Student x) {
        try {
            Connection con = StudentDAO.getConnect();
            PreparedStatement stmt = con.prepareStatement("insert into Hocvien values(?,?,?,?,?)");
            stmt.setString(1, x.getId());
            stmt.setString(2, x.getEmail());
            stmt.setString(3, x.getName());
            stmt.setInt(4, x.getCity());
            if (x.getSex().equalsIgnoreCase("Nam")) {
                stmt.setBoolean(5, true);
            } else {
                stmt.setBoolean(5, false);
            }
            stmt.executeUpdate();
            con.close();
            stmt.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public int removeStudent(String id) {
        try {
            Connection con = StudentDAO.getConnect();
            PreparedStatement stmt = con.prepareStatement("delete from Hocvien where Hocvien.MAHOCVIEN =? ");
            stmt.setString(1, id);
            stmt.executeUpdate();
            con.close();
            stmt.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
//    public static void main(String[] args) {
//        StudentDAO dao = new StudentDAO();
////        Student x = new Student("hv013", "Tran Dat", "emal", "Nam", 4);
//        
//    }
}
