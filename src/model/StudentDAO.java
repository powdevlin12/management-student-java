/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ket noi that bai !");
        }
        return null;
    }
    public static void main(String[] args) {
    }
}
