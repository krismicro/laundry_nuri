/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apl_Kris;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author micro
 */
public class Koneksi {

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;

    public void koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laundrykris", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DATABASE TIDAK TERKONEKSI"+e);
        }
    }
}
